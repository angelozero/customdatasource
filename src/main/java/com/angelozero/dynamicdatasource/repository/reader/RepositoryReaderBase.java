package com.angelozero.dynamicdatasource.repository.reader;


import com.angelozero.dynamicdatasource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReaderBase extends JpaRepository<UserEntity, Integer> {
}
