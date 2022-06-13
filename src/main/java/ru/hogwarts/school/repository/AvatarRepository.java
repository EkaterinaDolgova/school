package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Avatar;

import java.util.Collection;

public class AvatarRepository extends JpaRepository <Avatar, Long> {
    Collection<Avatar> findByAvatarId(Long,id);
}
