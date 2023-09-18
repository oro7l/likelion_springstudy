package com.likelion.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class LetterEntity {

    @Id @GeneratedValue
    @Column(name = "letter_id")
    private Long id;

    @ManyToOne //다대일관계 생각하기 -> 다 쪽이 연결 주인
    @JoinColumn(name = "box_id")
    private BoxEntity box;

    private LocalDateTime created_at;
    private String title;
    private String content;
    private String photo_url;

}
