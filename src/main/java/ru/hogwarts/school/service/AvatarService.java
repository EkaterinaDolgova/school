package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.repository.AvatarRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class AvatarService {
    @Value("${students.cover.dir=path}")
    private String coversDir;

    private final AvatarService avatarService;
    private final AvatarRepository avatarRepository;


    public AvatarService(AvatarService avatarService, AvatarRepository avatarRepository) {
        this.avatarService = avatarService;
        this.avatarRepository = avatarRepository;
    }
}
