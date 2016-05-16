/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.entity;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import com.haulmont.chile.core.annotations.NamePattern;

/**
 * @author mario
 */
@NamePattern("%s|name")
@DiscriminatorValue("CO")
@Entity(name = "compositionexample$Composite")
public class Composite extends Component {
    private static final long serialVersionUID = -5385614955985185944L;

}