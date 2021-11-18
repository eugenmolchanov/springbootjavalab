package com.itechart.javalab.repository;

import com.itechart.javalab.model.Lecturer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
public class CustomLecturerRepositoryImpl implements CustomLecturerRepository {
    
    private final EntityManager entityManager;
    
    @Override
    @Transactional
    public void customSave(Lecturer lecturer) {
        entityManager.persist(lecturer);
        System.out.println("Lecturer saved within Custom repo");
    }
}
