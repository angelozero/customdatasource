package com.angelozero.dynamicdatasource.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "user_info", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}
