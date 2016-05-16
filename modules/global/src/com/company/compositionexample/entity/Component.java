/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author mario
 */
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CN")
@NamePattern("%s|name")
@Table(name = "COMPOSITIONEXAMPLE_COMPONENT")
@Entity(name = "compositionexample$Component")
public class Component extends StandardEntity {
    private static final long serialVersionUID = 4888972201298130081L;

    @Column(name = "NAME")
    protected String name;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    protected Component parent;

    public void setParent(Component parent) {
        this.parent = parent;
    }

    public Component getParent() {
        return parent;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}