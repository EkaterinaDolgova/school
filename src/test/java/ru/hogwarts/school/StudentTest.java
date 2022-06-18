package ru.hogwarts.school;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class StudentTest {
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;
    @Autowired
    private StudentService studentService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }
    @Test
    public void getStudentInfoTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/1", String.class))
                .isNotNull();
    }
    @Test
    public void searchAgeStudentTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/filtr/1,2", String.class))
                .isNotNull();
    }
    @Test
    public void getFacultyStudentTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/faculty/5", String.class))
                .isNotNull();
    }
    @Test
    public void createStudentTest() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(10);

        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
    }
    @Test
    void deleteStudentTest() {
        HttpEntity<String> entity = new HttpEntity<>("OK", new HttpHeaders());
        ResponseEntity<String> response = restTemplate.exchange("/student/delete/4", HttpMethod.DELETE, entity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void editStudentTest() {
        Student student = new Student();
        student.setName("Bob");

        long id = studentService.createStudent(student).getId();
        Student student_ = new Student();
        student_.setName("Bob");
        HttpEntity<Student> entity = new HttpEntity<Student>(student_);
        ResponseEntity<Student> response = restTemplate.exchange("/student", HttpMethod.PUT, entity, Student.class,
                id);
        assertThat(response.getBody().getName(), is("Bob"));
    }


}
