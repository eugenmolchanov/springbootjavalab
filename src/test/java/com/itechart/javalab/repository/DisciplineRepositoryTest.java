package com.itechart.javalab.repository;

import com.itechart.javalab.model.Discipline;
import com.itechart.javalab.model.projection.DisciplineNameOnly;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class DisciplineRepositoryTest {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Test
    void countTest() {
        assertEquals(6, disciplineRepository.count());
    }

    @Test
    void findByNameTest() {
        String name = "Epistemology";
        Optional<Discipline> disciplineOptional = disciplineRepository.findByName(name);
        assertTrue(disciplineOptional.isPresent());
        assertEquals(name, disciplineOptional.get().getName());
    }

    @Test
    void findPagesByNameTest() {
        String name = "Epistemology";
        Page<Discipline> disciplinePage = disciplineRepository.findByName(name, PageRequest.of(0, 10));
        assertEquals(1, disciplinePage.getNumberOfElements());
        assertEquals(1, disciplinePage.getTotalElements());
        assertEquals(1, disciplinePage.getTotalPages());
    }

    @Test
    void findPagesTest() {
        List<Discipline> disciplines = disciplineRepository.findFirst3ByIsFree(true);
        assertEquals(3, disciplines.size());
    }

    @Test
    void findDisciplinePagesTest() {
        Page<Discipline> firstPage = disciplineRepository.findAll(PageRequest.of(0, 2));
        assertEquals(2, firstPage.getNumberOfElements());
        assertEquals(6, firstPage.getTotalElements());
        assertEquals(3, firstPage.getTotalPages());
    }

    @Test
    void findFreeTest() {
        List<Discipline> freeDisciplines = disciplineRepository.findByFree(true);
        assertEquals(5, freeDisciplines.size());
    }

    @Test
    void findNotFreeTest() {
        List<Discipline> freeDisciplines = disciplineRepository.findByFree(false);
        assertEquals(1, freeDisciplines.size());
    }

    @Test
    void findNamesOnlyTest() {
        List<DisciplineNameOnly> disciplinesWithNamesOnly = disciplineRepository.findAllByIsFree(false);

        assertEquals("Political Philosophy", disciplinesWithNamesOnly.get(0).getName());

    }
}
