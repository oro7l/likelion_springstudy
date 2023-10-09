package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "letter")
public class LetterEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //다대일관계 생각하기 -> 다 쪽이 연결 주인, 지연로딩 걸어주기
    @JoinColumn(name = "box_id")
    private BoxEntity box;

//    @CreatedDate
//    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
    private String photoUrl;

    @Builder
    public LetterEntity(BoxEntity box, String title, String content, String photoUrl) {
        this.box = box;
        this.title = title;
        this.content = content;
        this.photoUrl = photoUrl;
    }
}
