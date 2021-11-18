package com.itechart.javalab.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Document
@Data
public class Discipline {

    @MongoId
    private String id;
    private String name;
    private Boolean isFree;
    private Lecturer lecturer;

    @CreatedDate
    private Instant createdDate;
}
