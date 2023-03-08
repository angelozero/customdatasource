package com.angelozero.dynamicdatasource.usecase;


import com.angelozero.dynamicdatasource.entity.UserEntity;
import com.angelozero.dynamicdatasource.repository.reader.RepositoryReaderBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FindUser {

    private final RepositoryReaderBase repository;

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

}
