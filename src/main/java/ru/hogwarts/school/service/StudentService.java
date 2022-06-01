package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long key=0;

    public Student creatStudent(Student student){
        student.setId(++key);
        students.put(key,student);
        return student;
    }

}
