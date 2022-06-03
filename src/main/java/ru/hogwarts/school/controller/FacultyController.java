package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Map;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getFacultyInfo(@PathVariable Long id) {
        return facultyService.readFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.creatFaculty(faculty);
    }

    @PutMapping()
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("{userId}")
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("filtr/{color}")
    public Map<Long, String> searchColorFaculty(@PathVariable String color) {
        return facultyService.searchColorFaculty(color);
    }
}
