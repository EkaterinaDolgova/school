package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public Faculty getFacultyInfo(@PathVariable Long id) {
        return facultyService.readFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.creatFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filtr")
    public Collection<Faculty> searchFaculty(@RequestParam String color,@RequestParam String name) {
        if (color != null && !color.isBlank()) {
            return facultyService.searchColorFaculty(color,name);
        }
        return facultyService.getList();
    }

    @GetMapping
    public Collection<Faculty> printList() {
        return facultyService.getList();
    }

    @GetMapping("/students/{id}")
    public Collection<Student> getStudentsFaculty(@PathVariable Long id) {
        return facultyService.getStudents(id);
    }
}
