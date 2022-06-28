package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty creatFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty readFaculty(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Факультет не найден"));
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> searchColorFaculty(String name, String color) {
        if (name != null && !name.isBlank()) {
            return facultyRepository.findByColorOrNameIgnoreCase(name, color);
        }
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getList() {
        return facultyRepository.findAll();
    }

    public Collection<Student> getStudents(long id) throws Exception {
        return facultyRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Факультет не найден")).getStudents();
    }


}
