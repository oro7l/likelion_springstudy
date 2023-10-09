package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "letterbox")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoxEntity extends BaseTimeEntity {

    private static final int DEFAULT_LETTER_LIMIT = 20;

    private String code;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "box_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @OneToMany(mappedBy = "box")
    private final List<LetterEntity> letters = new ArrayList<>();


    private String name;


}
