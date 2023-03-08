package com.angelozero.customdatasource.usecase;


import com.angelozero.customdatasource.entity.UserEntity;
import com.angelozero.customdatasource.repository.writer.RepositoryWriteDataBase;
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
