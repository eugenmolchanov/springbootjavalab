package com.itechart.javalab.repository;

import com.itechart.javalab.model.Discipline;
import com.itechart.javalab.model.projection.DisciplineNameOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends CrudRepository<Discipline, String> {

    Optional<Discipline> findByName(String name);

    Page<Discipline> findByName(String name, Pageable pageable);

    List<Discipline> findFirst3ByIsFree(Boolean isFree);

    @Query("{'isFree': ?0}")
    List<Discipline> findByFree(boolean isFree);

    List<DisciplineNameOnly> findAllByIsFree(Boolean isFree);
    
    List<Discipline> findByLecturerGivenNameIgnoreCase(String givenName);
    
    List<Discipline> findByLecturerFamilyName(String familyName);

    void removeByName(String name);
}
