package com.likelion.springstudy.dto.response.letter;

import com.likelion.springstudy.domain.entity.LetterEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LetterGetResponse {
    private String title;
    private String content;

    public static LetterGetResponse of(LetterEntity letter){
        return new LetterGetResponse(letter.getTitle(), letter.getContent());
    }
}
