package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.MemberEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
    default MemberEntity findByIdOrThrow(Long id){
        return findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("%d에 해당하는 엔티티를 찾을 수 없습니다.",id)));
    }
}
