/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.web.component;

import com.company.compositionexample.entity.Composite;
import com.company.compositionexample.entity.Leaf;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mario
 */
public class ComponentBrowse extends AbstractLookup {



    @Inject
    Metadata metadata;
    @Inject
    Table componentsTable;

    public void createLeaf(Component source) {

        com.company.compositionexample.entity.Component entity = (com.company.compositionexample.entity.Component) componentsTable.getSingleSelected();
        Leaf item = metadata.create(Leaf.class);
        item.setParent(entity);

        AbstractEditor editor = openEditor(item, WindowManager.OpenType.DIALOG);
        editor.addListener(new Window.CloseListener() {
            @Override
            public void windowClosed(String actionId) {
                if (COMMIT_ACTION_ID.equals(actionId)) {
                    componentsTable.refresh();
                }
            }
        });
    }


    public void edit(Component source) {
        Entity entity = componentsTable.getSingleSelected();
        AbstractEditor editor = openEditor(entity, WindowManager.OpenType.DIALOG);
        editor.addListener(new Window.CloseListener() {
            @Override
            public void windowClosed(String actionId) {
                if (COMMIT_ACTION_ID.equals(actionId)) {
                    componentsTable.refresh();
                }
            }
        });
    }

    public void createComposite(Component source) {
        com.company.compositionexample.entity.Component entity = (com.company.compositionexample.entity.Component) componentsTable.getSingleSelected();
        Composite item = metadata.create(Composite.class);
        item.setParent(entity);

        AbstractEditor editor = openEditor(item, WindowManager.OpenType.DIALOG);

        editor.addListener(new Window.CloseListener() {
            @Override
            public void windowClosed(String actionId) {
                if (COMMIT_ACTION_ID.equals(actionId)) {
                    componentsTable.refresh();
                }
            }
        });
    }
}