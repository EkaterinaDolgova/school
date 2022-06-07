package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student readStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    /*    public Map<Long, String> searchAgeStudent ( int age){
            Map<Long, String> filteredMap = students.entrySet().stream().filter(x -> x.getValue().getAge() == age).collect(Collectors.toMap(x -> x.getKey(), x -> x.toString()));
            return filteredMap;
        }*/

    public Collection<Student> getList() {
        return studentRepository.findAll();
    }


}
