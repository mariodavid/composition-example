/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.web.leaf;

import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.compositionexample.entity.Leaf;
import com.haulmont.cuba.gui.components.PickerField;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mario
 */
public class LeafEdit extends AbstractEditor<Leaf> {

    @Named("fieldGroup.parent")
    protected PickerField parentField;


    @Override
    protected void postInit() {
        PickerField.LookupAction lookupAction = (PickerField.LookupAction) parentField.getAction("lookup");
        lookupAction.setLookupScreen("compositionexample$Composite.browse");
    }
}