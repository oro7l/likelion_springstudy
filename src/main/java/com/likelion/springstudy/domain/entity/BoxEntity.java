package com.likelion.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class BoxEntity {

    @Id @GeneratedValue
    @Column(name = "box_id")
    private Long id;

    @OneToOne(mappedBy = "box")
    private MemberEntity member;

    @OneToMany(mappedBy = "box")
    private List<LetterEntity> letters = new ArrayList<>();


    private String name;


}
