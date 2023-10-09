package com.likelion.springstudy.dto.response.member;

import com.likelion.springstudy.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberGetResponse {

    private String name; //key, 내가 넣는 값이 value
    private String nickname;

    public static MemberGetResponse of(MemberEntity member) {
        return new MemberGetResponse(member.getName(), member.getNickname())
    }//엔티티를 dto로 바꿔주는 메서드
}
