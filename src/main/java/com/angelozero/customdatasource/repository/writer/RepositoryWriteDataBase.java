package com.angelozero.customdatasource.repository.writer;


import com.angelozero.customdatasource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryWriteDataBase extends JpaRepository<UserEntity, Integer> {
}
