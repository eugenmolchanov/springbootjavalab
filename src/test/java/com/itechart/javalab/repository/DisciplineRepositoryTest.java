package com.itechart.javalab.repository;

import com.itechart.javalab.model.Discipline;
import com.itechart.javalab.model.Lecturer;
import com.itechart.javalab.model.projection.DisciplineNameOnly;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DisciplineRepositoryTest {

    @Autowired
    private DisciplineRepository disciplineRepository;
    
    @Autowired
    private LecturerRepository lecturerRepository;

    @BeforeAll
    void init() {
        Lecturer oldLecturer = lecturer("Old", "One");
        Lecturer youngLecturer = lecturer("Young", "One");
        lecturerRepository.customSave(oldLecturer);
        lecturerRepository.customSave(youngLecturer);
        disciplineRepository.saveAll(List.of(
                discipline("Epistemology", true, oldLecturer),
                discipline("Logic", true, oldLecturer),
                discipline("Metaphysics", true, youngLecturer),
                discipline("Ethics", true, youngLecturer),
                discipline("Aesthetics", true, oldLecturer),
                discipline("Political Philosophy", false, oldLecturer))
        );
    }
    
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
        assertNotNull(disciplineOptional.get().getCreatedDate());
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
    
    @Test
    void shouldFindByLectureGivenName() {
        List<Discipline> disciplines = disciplineRepository.findByLecturerGivenNameIgnoreCase("old");
        Lecturer lecturer = disciplines.get(0).getLecturer();

        assertEquals(4, disciplines.size());
        assertNotNull(lecturer.getGivenName());
        assertNotNull(lecturer.getFamilyName());
    }

    @Test
    void shouldRemoveByName() {
        assertTrue(disciplineRepository.findByName("Test").isEmpty());

        Discipline disciplineToRemove = new Discipline();
        disciplineToRemove.setName("Test");
        disciplineRepository.save(disciplineToRemove);

        Optional<Discipline> disciplineToRemoveSaved = disciplineRepository.findByName("Test");

        assertTrue(disciplineToRemoveSaved.isPresent());
        assertEquals("Test", disciplineToRemoveSaved.get().getName());
        
        disciplineRepository.removeByName("Test");

        assertTrue(disciplineRepository.findByName("Test").isEmpty());
    }

    private Discipline discipline(String name, boolean isFree, Lecturer lecturer) {
        Discipline discipline = new Discipline();
        discipline.setName(name);
        discipline.setIsFree(isFree);
        discipline.setLecturer(lecturer);
        return discipline;
    }

    private Lecturer lecturer(String givenName, String familyName) {
        Lecturer lecturer = new Lecturer();
        lecturer.setGivenName(givenName);
        lecturer.setFamilyName(familyName);
        return lecturer;
    }
}
