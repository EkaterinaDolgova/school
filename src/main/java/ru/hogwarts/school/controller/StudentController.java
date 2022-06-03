package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping()
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{userId}")
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
    @GetMapping("filtr/{age}")
    public Map<Long, String> searchAgeStudent(@PathVariable int age) {
        return studentService.searchAgeStudent(age);
    }

    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable Long id) {
        return studentService.readStudent(id);
    }
    @GetMapping()
    public HashMap<Long, Student> printList() {
        return studentService.getList();
    }
}
