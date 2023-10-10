package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.repository.LetterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {

    private final LetterJpaRepository letterJpaRepository;

    @Transactional //편지 생성, 생성은 따로 붙어줘야 함
    public void create(LetterCreateRequest request) {
        letterJpaRepository.save(LetterEntity
                LetterCreateRequest.toLetter(request.getTitle(), request.getContent()));

    }

    //편지 목록 조회
    public List<LetterEntity> getAll() {
        return letterJpaRepository.findAll()
    }

}
