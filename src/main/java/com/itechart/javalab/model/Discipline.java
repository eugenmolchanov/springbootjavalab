package com.itechart.javalab.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Discipline {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String abbreviation;
    @Column(name = "FREE_ACCESS")
    private Boolean isFree;
}
