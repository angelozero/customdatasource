package com.angelozero.dynamicdatasource.repository.writer;


import com.angelozero.dynamicdatasource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryWriteDataBase extends JpaRepository<UserEntity, Integer> {
}
