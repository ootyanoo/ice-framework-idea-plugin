package org.xblackcat.frozenidea.integration;

import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.xblackcat.frozenidea.config.IceComponent;
import org.xblackcat.frozenidea.psi.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 14.06.12 16:23
 *
 * @author xBlackCat
 */
public class SliceHelper {
    public static String getPackageName(PsiFile file, IceComponent target) {
        List<SliceGlobalMetadata> globalMetadatas = PsiTreeUtil.getChildrenOfTypeAsList(
                file,
                SliceGlobalMetadata.class
        );
        for (SliceGlobalMetadata md : globalMetadatas) {
            for (SliceMetadataElement el : md.getMetadataElementList()) {
                final String text = el.getStringLiteral().getText();
                String packageString = target.extractPackageName(text.substring(1, text.length() - 1));

                if (packageString != null) {
                    return packageString;
                }
            }
        }

        return null;
    }

    public static void collectName(StringBuilder res, SliceModule module) {
        if (module == null) {
            return;
        }
        final PsiElement id = module.getId();
        if (id == null) {
            return;
        }

        collectName(res, PsiTreeUtil.getParentOfType(module, SliceModule.class));

        res.append(id.getText());
        res.append(".");
    }

    public static String getFQN(SliceNamedElement element) {
        final PsiElement id = element.getId();
        if (id == null) {
            return null;
        }
        String name = id.getText();

        if (name == null) {
            return null;
        }

        SliceModule module = getContainerSliceModule(element);
        if (module == null) {
            return null;
        }
        return buildFQN(name, module);
    }

    public static
    @NotNull
    String buildFQN(String name, SliceModule module) {
        String packageName = SliceHelper.getPackageName(module.getContainingFile(), IceComponent.Java);

        StringBuilder fqn = new StringBuilder();
        if (packageName != null) {
            fqn.append(packageName);
            fqn.append(".");
        }

        SliceHelper.collectName(fqn, module);

        fqn.append(name);

        return fqn.toString();
    }

    public static SliceModule getContainerSliceModule(SliceNamedElement element) {
        SliceModule module;
        if (element instanceof SliceModule) {
            module = PsiTreeUtil.getParentOfType(element, SliceModule.class);
        } else if (element instanceof SliceDataTypeElement) {
            module = ((SliceDataTypeElement) element).getModule();
        } else {
            module = null;
        }
        return module;
    }

    public static PsiClass searchImplementation(SliceDataTypeElement element) {
        if (element == null) {
            return null;
        }

        final PsiElement id = element.getId();
        if (id == null) {
            return null;
        }
        String name = id.getText();

        if (name == null) {
            return null;
        }

        SliceModule module = getContainerSliceModule(element);
        if (module == null) {
            return null;
        }
        final String implFQN = buildFQN("_" + name + "Operations", module);

        return checkJavaClass(element, implFQN);
    }

    private static PsiClass checkJavaClass(SliceDataTypeElement element, String implFQN) {
        JavaModuleHelper javaHelper = JavaModuleHelper.getJavaHelper(element);
        NavigatablePsiElement aClass = javaHelper.findClass(implFQN);

        if ((aClass instanceof PsiClass)) {
            return (PsiClass) aClass;
        }
        return null;

    }

    public static void findAllSubclasses(
            Set<SliceDataTypeElement> elements,
            SliceModule module,
            SliceClassDef element
    ) {
        final HashSet<SliceClassDef> set = new HashSet<SliceClassDef>();
        set.add(element);
        findAllSubclasses(elements, module, set);
    }

    private static void findAllSubclasses(Set<SliceDataTypeElement> elements, SliceModule module, Set<SliceClassDef> parents) {
        for (SliceClassDef clazz : module.getClassDefList()) {
            if (parents.contains(clazz)) {
                continue;
            }

            if (clazz.getClassBody() == null) {
                // Ignore forward definitions
                continue;
            }

            SliceExtendsList extendsList = clazz.getExtendsList();
            if (extendsList == null) {
                continue;
            }

            for (SliceTypeReference tr : extendsList.getTypeReferenceList()) {
                final PsiElement psiElement = tr.getReference().resolve();

                if (psiElement instanceof SliceClassDef) {
                    if (parents.contains(psiElement)) {
                        elements.add(clazz);
                        parents.add(clazz);
                        break;
                    }
                }
            }
        }
    }

    public static void findAllImplementations(Set<SliceDataTypeElement> elements, SliceModule module, SliceInterfaceDef element) {
        Set<SliceClassDef> supers = new HashSet<SliceClassDef>();

        Set<SliceInterfaceDef> hierarchy = new HashSet<SliceInterfaceDef>();
        hierarchy.add(element);

        for (SliceInterfaceDef interfaceDef : module.getInterfaceDefList()) {
            if (interfaceDef.equals(element)) {
                continue;
            }
            if (interfaceDef.getInterfaceBody() == null) {
                // Ignore forward definitions
                continue;
            }

            SliceExtendsList extendsList = interfaceDef.getExtendsList();
            if (extendsList == null) {
                continue;
            }

            for (SliceTypeReference tr : extendsList.getTypeReferenceList()) {
                final PsiElement psiElement = tr.getReference().resolve();

                if (psiElement instanceof SliceInterfaceDef) {
                    if (hierarchy.contains(psiElement)) {
                        elements.add(interfaceDef);
                        hierarchy.add(interfaceDef);
                    }
                }
            }
        }

        final List<SliceClassDef> classDefList = module.getClassDefList();
        for (SliceClassDef clazz : classDefList) {
            if (clazz.getClassBody() == null) {
                // Ignore forward definitions
                continue;
            }

            SliceImplementsList implementsList = clazz.getImplementsList();
            if (implementsList != null) {
                for (SliceTypeReference tr : implementsList.getTypeReferenceList()) {
                    final PsiElement psiElement = tr.getReference().resolve();

                    if (psiElement instanceof SliceInterfaceDef) {
                        if (hierarchy.contains(psiElement)) {
                            elements.add(clazz);
                            supers.add(clazz);
                        }
                    }
                }
            }
        }

        findAllSubclasses(elements, module, supers);
    }
}
