package com.itechart.javalab.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Discipline {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "IS_FREE")
    private Boolean isFree;
    @ManyToOne(fetch = FetchType.LAZY)
    private Lecturer lecturer;

    @CreatedDate
    private Instant createdDate;
}
