package com.likelion.springstudy.controller;

import com.likelion.springstudy.dto.response.member.MemberGetResponse;
import com.likelion.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //serializer가 된 controller + responsebody
@RequestMapping("api/member/") //어디다가 mapping할 지
@RequiredArgsConstructor //final로 정의한 변수를 생성 -> 의존성 주입 (dependency injection) 중 생성자 주입 방식
public class MemberController {

    private final MemberService memberService;

    //사용자 정보를 조회하는 api
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberService.getById(memberId));
    }
}
