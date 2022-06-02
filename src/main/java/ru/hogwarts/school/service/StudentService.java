package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long key = 0;

    public Student createStudent(Student student) {
        student.setId(++key);
        students.put(key, student);
        return student;
    }

    public Student readStudent(long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Map<Long, String> searchAgeStudent(int age) {
        Map<Long, String> filteredMap = students.entrySet()
                .stream().filter(x->x.getValue().getAge() == age)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.toString()));
        return filteredMap;
    }


}
