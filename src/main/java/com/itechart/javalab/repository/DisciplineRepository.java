package com.itechart.javalab.repository;

import com.itechart.javalab.model.Discipline;
import com.itechart.javalab.model.projection.DisciplineNameOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {

    Optional<Discipline> findByName(String name);

    Page<Discipline> findByName(String name, Pageable pageable);

    List<Discipline> findFirst3ByIsFree(Boolean isFree);

    @Query("select d from Discipline d where isFree = ?1")
    List<Discipline> findByFree(boolean isFree);

    List<DisciplineNameOnly> findAllByIsFree(Boolean isFree);
}
