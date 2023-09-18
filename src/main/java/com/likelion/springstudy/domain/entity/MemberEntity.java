package com.likelion.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity //entity는 table, pk가 꼭 있어야 한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // argument없는 생성자를 만들어준다. (생성자 선언하기 위해서)
@Getter 
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 전략
    private Long id; //private인 이유 : 객체의 성질 중 캡슐화(다른 클래스가 내 클래스를 알지 못하게, 소통은 행위로만)를 만족하기 위해

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true) //db에 들어가는 시점에 null 여부 확인
    private String nickname;

    @Column(nullable = false)
    private String password;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Enumerated //상태 표시할 때
    private LetterStatus is_deleted;
    private LocalDateTime deleted_at;

    @OneToOne
    @JoinColumn(name = "box_id") //일대일관계 생각하기 -> 더 많이 접근하는 쪽이 연결 주인
    private BoxEntity box;

    @Builder
    public MemberEntity(Long id, String username, String nickname, String password) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }
    //    //private Integer age;
//    private int age; //Integer와 int의 차이 : java에는 원시타입(int, null 안됨)과 wrapping 타입(Integer) 존재, jpa에서 pk는 wrapper class로
//    private boolean isAdult; //boolean에서는 wrapper 클래스로 안하는게 좋다. 들어갈 수 있는 값이 null까지 3개가 되니까
//
//    //생성자 만들기 (커맨드 n) -> 나영경 블로그 참고하기
//    public MemberEntity(Long id, String name, String nickname, int age, boolean isAdult) {
//        this.id = id;
//        this.name = name;
//        this.nickname = nickname;
//        this.age = age;
//        this.isAdult = isAdult;
//    }

}
