package com.angelozero.dynamicdatasource.usecase;


import com.angelozero.dynamicdatasource.entity.UserEntity;
import com.angelozero.dynamicdatasource.repository.writer.RepositoryWriteDataBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveUser {

    private final RepositoryWriteDataBase repository;

    public void save() {
        repository.saveAndFlush(UserEntity.builder()
                .name("Angelo")
                .build());
    }
}
