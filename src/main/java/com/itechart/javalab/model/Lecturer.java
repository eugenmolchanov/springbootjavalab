package com.itechart.javalab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Lecturer {

    @Id
    @GeneratedValue
    private Long id;
    private String givenName;
    private String familyName;
}
