package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface StudentRepository extends JpaRepository<Student, Long>{
    Collection<Student> findByAgeBetween(int min, int max);

    @Query(value = "Select count(id) from student", nativeQuery = true)
    Integer sumStudents() ;
    @Query(value = "Select avg(age) from student", nativeQuery = true)
    Integer avgStudents() ;
    @Query(value = "Select * from student ORDER BY id DESC  LIMIT 5 ", nativeQuery = true)
    List<Student> fiveStudents() ;

    }


