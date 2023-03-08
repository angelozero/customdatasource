package com.angelozero.customdatasource.controller;


import com.angelozero.customdatasource.entity.UserEntity;
import com.angelozero.customdatasource.usecase.FindUser;
import com.angelozero.customdatasource.usecase.SaveUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final SaveUser saveUser;
    private final FindUser findUser;

    @GetMapping(value = "/find-all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(findUser.findAll());
    }

    @GetMapping(value = "/save")
    public ResponseEntity<Void> save() {
        saveUser.save();
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/save-and-find")
    public ResponseEntity<List<UserEntity>> saveAndFind() {
        saveUser.save();
        List<UserEntity> users = findUser.findAll();
        return ResponseEntity.ok(users);
    }
}
