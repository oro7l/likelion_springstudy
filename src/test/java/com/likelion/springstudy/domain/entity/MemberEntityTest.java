package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberEntityTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @DisplayName("멤버가 성공적으로 생성된다.")
    @Test
    void test(){
        // given
        MemberEntity member = MemberEntity.builder()
                .id(1L)
                .username("oro7l")
                .nickname("기웅시치")
                .password("lgu6206")
                .build();

        memberJpaRepository.save(member);

        // when
        MemberEntity findMember = memberJpaRepository.findById(1L).orElseThrow(EntityNotFoundException::new);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(1L);
    }
}
