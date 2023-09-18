package com.likelion.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class BoxEntity {

    @Id @GeneratedValue
    @Column(name = "box_id")
    private Long id;

    @OneToOne(mappedBy = "box")
    private MemberEntity member;

    @OneToMany(mappedBy = "letter")
    private LetterEntity letter;


    private String name;


}
