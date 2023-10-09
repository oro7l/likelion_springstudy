package com.likelion.springstudy.controller;

import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/letter")
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping
    public ResponseEntity<Void> sendLetter(@RequestBody LetterCreateRequest request) { //LetterCreateRequest가 Dto
        URI location = URI.create("api/letter/" + letterService.create(request));
        return ResponseEntity.created(location).build();
    }
}
