package com.itechart.javalab.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
public class Lecturer {

    @MongoId
    private String id;
    private String givenName;
    private String familyName;
}
