package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.dto.request.box.BoxCreateRequest;
import com.likelion.springstudy.dto.response.box.BoxGetResponse;
import com.likelion.springstudy.repository.BoxJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {
    private final BoxJpaRepository boxJpaRepository;

    @Transactional //편지함 생성, 생성은 따로 붙어줘야 함
    public void create(BoxCreateRequest request) {
        boxJpaRepository.save(BoxEntity
                BoxCreateRequest.toBox(request.getName()));

    }

    //편지함 목록 조회
    @Transactional(readOnly = true)
    public List<BoxGetResponse> getAll() {
        List<BoxEntity> boxList = boxJpaRepository.findAll();
        return boxList.stream().map(BoxGetResponse::of).collect(Collectors.toList());

    }
}
