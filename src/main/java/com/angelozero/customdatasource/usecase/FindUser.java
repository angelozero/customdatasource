package com.angelozero.customdatasource.usecase;


import com.angelozero.customdatasource.config.DataSourceAnnotation;
import com.angelozero.customdatasource.entity.UserEntity;
import com.angelozero.customdatasource.repository.reader.RepositoryReaderBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@DataSourceAnnotation
@RequiredArgsConstructor
public class FindUser {

    private final RepositoryReaderBase repository;

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

}
