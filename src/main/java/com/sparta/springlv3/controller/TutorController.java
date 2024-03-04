package com.sparta.springlv3.controller;

import com.sparta.springlv3.dto.TutorRequestDto;
import com.sparta.springlv3.dto.TutorResponseDto;
import com.sparta.springlv3.entity.User;
import com.sparta.springlv3.entity.UserRoleEnum;
import com.sparta.springlv3.service.TutorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/tutor")
    public TutorResponseDto register(@RequestBody TutorRequestDto requestDto, HttpServletRequest req) {
        return tutorService.register(requestDto);
    }

    @PutMapping("/tutor/{tutorId}")
    public TutorResponseDto update(@PathVariable Long tutorId, @RequestBody TutorRequestDto requestDto, HttpServletRequest req) {
        User user = (User) req.getAttribute("user");
        if (user.getRole().equals(UserRoleEnum.MANAGER)) {
            return tutorService.update(tutorId, requestDto);
        } else throw new IllegalArgumentException("권한이 없습니다.");
    }
}
