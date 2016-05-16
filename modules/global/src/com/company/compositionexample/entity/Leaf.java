/*
 * Copyright (c) 2016 composition-example
 */
package com.company.compositionexample.entity;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

/**
 * @author mario
 */
@DiscriminatorValue("LE")
@Entity(name = "compositionexample$Leaf")
public class Leaf extends Component {
    private static final long serialVersionUID = -3720407688850559799L;

}