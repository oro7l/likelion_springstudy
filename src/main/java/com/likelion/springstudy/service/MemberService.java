package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.MemberEntity;
import com.likelion.springstudy.dto.response.member.MemberGetResponse;
import com.likelion.springstudy.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //단위에 맞춰서 db에 변경요청을 보냄 (*영속성컨텍스트) 클래스 안 transaction이 우선 적용, 실수 방지용
public class MemberService {

    private final MemberJpaRepository memberJpaRepository; //의존성 주입

//    public MemberGetResponse getById(Long id) {
//        MemberEntity member = memberJpaRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원을 찾을 수 없습니다.")); //exception은 자주 쓰는 게 정해져 있고, 외워야함
//        return MemberGetResponse.of(member); //dto를 리턴해야 함
//    }
//    public MemberGetResponse getById(Long id){
//        return MemberGetResponse.of(findById(id));
//    }

    public MemberGetResponse getById(Long id){
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    private MemberEntity findById(Long id) {
        return memberJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원을 찾을 수 없습니다."));
    }
}
