/*
 * Copyright 2000-2009 JetBrains s.r.o.
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
package org.xblackcat.frozenidea.find.usages;

import com.intellij.find.FindBundle;
import com.intellij.find.FindSettings;
import com.intellij.find.findUsages.*;
import com.intellij.openapi.help.HelpManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.util.MethodSignatureUtil;
import com.intellij.ui.SimpleColoredComponent;
import com.intellij.ui.StateRestoringCheckBox;
import com.intellij.usageView.UsageViewUtil;

import javax.swing.*;

public abstract class SliceFindUsagesDialog<T extends SliceFindUsagesOptions> extends AbstractFindUsagesDialog {
    protected final PsiElement myPsiElement;
    private StateRestoringCheckBox myCbIncludeOverloadedMethods;
    private boolean myIncludeOverloadedMethodsAvailable = false;

    protected SliceFindUsagesDialog(
            PsiElement element,
            Project project,
            FindUsagesOptions findUsagesOptions,
            boolean toShowInNewTab,
            boolean mustOpenInNewTab,
            boolean isSingleFile,
            FindUsagesHandler handler
    ) {
        super(
                project, findUsagesOptions, toShowInNewTab, mustOpenInNewTab, isSingleFile, isTextSearch(
                element,
                isSingleFile,
                handler
        ), !isSingleFile && !element.getManager().isInProject(element)
        );
        myPsiElement = element;
        myIncludeOverloadedMethodsAvailable = element instanceof PsiMethod &&
                MethodSignatureUtil.hasOverloads((PsiMethod) element);
        init();
    }

    private static boolean isTextSearch(PsiElement element, boolean isSingleFile, FindUsagesHandler handler) {
        return FindUsagesUtil.isSearchForTextOccurrencesAvailable(element, isSingleFile, handler);
    }

    public void calcFindUsagesOptions(T options) {
//    if (options instanceof JavaMethodFindUsagesOptions) {
//      ((JavaMethodFindUsagesOptions)options).isIncludeOverloadUsages =
//        myIncludeOverloadedMethodsAvailable && isToChange(myCbIncludeOverloadedMethods) && myCbIncludeOverloadedMethods.isSelected();
//    }
    }

    @Override
    public void calcFindUsagesOptions(FindUsagesOptions options) {
        super.calcFindUsagesOptions(options);
        calcFindUsagesOptions((T) options);
    }

    @Override
    protected void doOKAction() {
        if (shouldDoOkAction()) {
            if (myIncludeOverloadedMethodsAvailable) {
                FindSettings.getInstance().setSearchOverloadedMethods(myCbIncludeOverloadedMethods.isSelected());
            }
        } else {
            return;
        }
        super.doOKAction();
    }

    @Override
    protected void addUsagesOptions(JPanel optionsPanel) {
        super.addUsagesOptions(optionsPanel);
        if (myIncludeOverloadedMethodsAvailable) {
            myCbIncludeOverloadedMethods = addCheckboxToPanel(
                    FindBundle.message("find.options.include.overloaded.methods.checkbox"),
                    FindSettings.getInstance().isSearchOverloadedMethods(), optionsPanel, false
            );

        }
    }

    @Override
    protected boolean isInFileOnly() {
        return super.isInFileOnly() ||
                myPsiElement != null && PsiSearchHelper.SERVICE.getInstance(myPsiElement.getProject()).getUseScope(
                        myPsiElement
                ) instanceof LocalSearchScope;
    }

    @Override
    public void configureLabelComponent(final SimpleColoredComponent coloredComponent) {
        coloredComponent.append(StringUtil.capitalize(UsageViewUtil.getType(myPsiElement)));
        coloredComponent.append(" ");
        coloredComponent.append(UsageViewUtil.getLongName(myPsiElement));
    }

    protected final PsiElement getPsiElement() {
        return myPsiElement;
    }

    @Override
    protected void doHelpAction() {
        HelpManager.getInstance().invokeHelp(FindUsagesManager.getHelpID(myPsiElement));
    }

    protected T getFindUsagesOptions() {
        return (T) myFindUsagesOptions;
    }
}
