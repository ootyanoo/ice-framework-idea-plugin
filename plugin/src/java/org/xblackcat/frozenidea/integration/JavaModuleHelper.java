/*
 * Copyright 2011-2012 Gregory Shrago
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xblackcat.frozenidea.integration;

import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleServiceManager;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.JavaClassReferenceProvider;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gregsh
 */
public class JavaModuleHelper {
    protected Module module;

    public JavaModuleHelper(Module module) {
        this.module = module;
    }

    public static JavaModuleHelper getJavaHelper(Module module) {
        JavaModuleHelper service = ModuleServiceManager.getService(module, JavaModuleHelper.class);
        return service == null ? new JavaModuleHelper(module) : service;
    }

    public static JavaModuleHelper getJavaHelper(PsiElement element) {
        Module module = ModuleUtil.findModuleForPsiElement(element);

        if (module != null) {
            JavaModuleHelper service = ModuleServiceManager.getService(module, JavaModuleHelper.class);

            if (service != null) {
                return service;
            }
        }

        return new JavaModuleHelper(module);
    }

    @Nullable
    public PsiReferenceProvider getClassReferenceProvider() {
        return null;
    }

    @Nullable
    public NavigatablePsiElement findClass(String className) {
        return null;
    }

    @Nullable
    public NavigationItem findPackage(String packageName) {
        return null;
    }

    @Nullable
    public NavigatablePsiElement findClassMethod(String className, String methodName, int paramCount) {
        return null;
    }

    @NotNull
    public List<NavigatablePsiElement> getClassMethods(String className, boolean staticMethods) {
        return Collections.emptyList();
    }

    @NotNull
    public List<String> getMethodTypes(NavigatablePsiElement method) {
        return Collections.singletonList("void");
    }

    @NotNull
    public List<String> getAnnotations(NavigatablePsiElement element) {
        return Collections.emptyList();
    }

    private static class Impl extends JavaModuleHelper {
        private final JavaPsiFacade myFacade;

        private Impl(Module module, JavaPsiFacade facade) {
            super(module);
            myFacade = facade;
        }

        @Override
        public PsiReferenceProvider getClassReferenceProvider() {
            JavaClassReferenceProvider provider = new JavaClassReferenceProvider();
            provider.setSoft(false);
            return provider;
        }

        @Override
        public PsiClass findClass(String className) {
            if (className == null) {
                return null;
            }
            return myFacade.findClass(className, GlobalSearchScope.moduleWithDependentsScope(module));
        }

        @Override
        public NavigationItem findPackage(String packageName) {
            return myFacade.findPackage(packageName);
        }

        @Override
        public PsiMethod findClassMethod(String className, String methodName, int paramCount) {
            PsiClass aClass = findClass(className);
            PsiMethod[] methods = aClass == null ? PsiMethod.EMPTY_ARRAY : aClass.findMethodsByName(methodName, true);
            for (PsiMethod method : methods) {
                if (paramCount < 0 || paramCount + 2 == method.getParameterList().getParametersCount()) {
                    return method;
                }
            }
            return methods.length > 0 ? methods[0] : null;
        }

        @NotNull
        @Override
        public List<NavigatablePsiElement> getClassMethods(String className, boolean staticMethods) {
            PsiClass aClass = findClass(className);
            if (aClass == null) {
                return Collections.emptyList();
            }
            final ArrayList<NavigatablePsiElement> result = new ArrayList<NavigatablePsiElement>();
            for (PsiMethod method : aClass.getAllMethods()) {
                PsiModifierList modifierList = method.getModifierList();
                if (modifierList.hasExplicitModifier(PsiModifier.PUBLIC) &&
                        staticMethods == modifierList.hasExplicitModifier(PsiModifier.STATIC)) {
                    result.add(method);
                }
            }
            return result;
        }

        @NotNull
        @Override
        public List<String> getMethodTypes(NavigatablePsiElement method) {
            if (method == null) {
                return Collections.emptyList();
            }
            PsiMethod psiMethod = (PsiMethod) method;
            PsiType returnType = psiMethod.getReturnType();
            List<String> strings = new ArrayList<String>();
            strings.add(returnType == null ? "void" : returnType.getCanonicalText());
            for (PsiParameter parameter : psiMethod.getParameterList().getParameters()) {
                strings.add(parameter.getType().getCanonicalText());
                strings.add(parameter.getName());
            }
            return strings;
        }

        @NotNull
        @Override
        public List<String> getAnnotations(NavigatablePsiElement element) {
            if (element == null) {
                return Collections.emptyList();
            }
            PsiModifierList modifierList = ((PsiModifierListOwner) element).getModifierList();
            if (modifierList == null) {
                return super.getAnnotations(element);
            }
            List<String> strings = new ArrayList<String>();
            for (PsiAnnotation annotation : modifierList.getAnnotations()) {
                if (annotation.getParameterList().getAttributes().length > 0) {
                    continue;
                }
                strings.add(annotation.getQualifiedName());
            }
            return strings;
        }
    }
}
