/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.web.composite;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.compositionexample.entity.Composite;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.web.gui.components.WebPickerField;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mario
 */
public class CompositeEdit extends AbstractEditor<Composite> {


    @Named("fieldGroup.parent")
    protected PickerField parentField;


    @Override
    public void init(Map<String, Object> params) {
        PickerField.LookupAction lookupAction = (PickerField.LookupAction) parentField.getAction("lookup");
        lookupAction.setLookupScreen("compositionexample$Composite.browse");
        Map<String,Object> lookupParams = new HashMap<>();


        params.put("hello", getItem());
        lookupAction.setLookupScreenParams(lookupParams);
        super.init(params);
    }
}