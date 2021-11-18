package com.itechart.javalab.repository;

import com.itechart.javalab.model.Discipline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;

@RepositoryDefinition(domainClass = Discipline.class, idClass = Integer.class)
public interface CustomDisciplineRepository {

    long count();

    Optional<Discipline> findByName(String name);

    Page<Discipline> findAll(Pageable pageable);

    Iterable<Discipline> saveAll(Iterable<Discipline> disciplines);
}
