package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> facults = new HashMap<>();
    private long key = 0;

    public Faculty creatFaculty(Faculty faculty) {
        faculty.setId(++key);
        facults.put(key, faculty);
        return faculty;
    }

    public Faculty readFaculty(long id) {
        return facults.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        facults.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return facults.remove(id);
    }

    public Map<Long, String> searchColorFaculty(String color) {
        Map<Long, String> filteredMap = facults.entrySet()
                .stream().filter(x->x.getValue().getColor().equals( color))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.toString()));
        return filteredMap;
    }
}
