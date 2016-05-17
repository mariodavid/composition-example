/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.web.composite;

import com.company.compositionexample.entity.Composite;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.data.HierarchicalDatasource;

import javax.inject.Inject;
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
            compositesDs.excludeItem((Composite) params.get("exclude"));
        }

    }

}