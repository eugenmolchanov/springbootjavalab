package com.itechart.javalab.repository;

import com.itechart.javalab.model.Lecturer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomLecturerRepositoryImpl implements CustomLecturerRepository {
    
    private final MongoTemplate mongoTemplate;
    
    @Override
    public void customSave(Lecturer lecturer) {
        mongoTemplate.save(lecturer);
        System.out.println("Lecturer saved within Custom repo");
    }
}
