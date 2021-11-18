package com.itechart.javalab.repository;

import com.itechart.javalab.model.Lecturer;
import org.springframework.data.repository.CrudRepository;

public interface LecturerRepository extends CrudRepository<Lecturer, String>, CustomLecturerRepository {
}
