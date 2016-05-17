/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.web.composite;

import com.company.compositionexample.entity.Composite;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.data.HierarchicalDatasource;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * @author mario
 */
public class CompositeBrowse extends AbstractLookup {


    @Inject
    protected TreeTable<Composite> compositesTable;

    @Inject
    protected HierarchicalDatasource<Composite, UUID> compositesDs;

    @Override
    public void init(Map<String, Object> params) {
        compositesTable.refresh();

        if (params.containsKey("exclude")) {
            Composite currenctComponent = (Composite) params.get("exclude");
            removeElementAndSubelementsFromTree(currenctComponent.getId());
        }
    }

    private void removeElementAndSubelementsFromTree(UUID parent) {
        removeSubelementsFromTree(parent);
        compositesDs.excludeItem(compositesDs.getItem(parent));
    }

    private void removeSubelementsFromTree(UUID parent) {
        Collection<UUID> children = compositesDs.getChildren(parent);

        for(UUID child : children) {
            if (compositesDs.hasChildren(child)) {
                removeSubelementsFromTree(child);
            }
            Composite currentItem = compositesDs.getItem(child);
            compositesDs.excludeItem(currentItem);
        }
    }

}