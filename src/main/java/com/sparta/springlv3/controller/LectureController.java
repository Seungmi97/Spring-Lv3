package com.sparta.springlv3.controller;

import com.sparta.springlv3.dto.LectureRequestDto;
import com.sparta.springlv3.dto.LectureResponseDto;
import com.sparta.springlv3.dto.TutorRequestDto;
import com.sparta.springlv3.dto.TutorResponseDto;
import com.sparta.springlv3.entity.Lecture;
import com.sparta.springlv3.entity.LectureCategory;
import com.sparta.springlv3.entity.User;
import com.sparta.springlv3.entity.UserRoleEnum;
import com.sparta.springlv3.service.LectureService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LectureController {

    private  final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("/lecture")
    public LectureResponseDto register(@RequestBody LectureRequestDto lectureRequestDto) {
        return lectureService.register(lectureRequestDto);
    }

    @PutMapping("/lecture/{lectureId}")
    public LectureResponseDto update(@PathVariable Long lectureId, @RequestBody LectureRequestDto requestDto, HttpServletRequest req) {
        User user = (User) req.getAttribute("user");
        if (user.getRole().equals(UserRoleEnum.MANAGER)) {
            return lectureService.update(lectureId, requestDto);
        } else throw new IllegalArgumentException("권한이 없습니다.");
    }

    @GetMapping("/lecture/{lectureId}")
    public LectureResponseDto find(@PathVariable Long lectureId) {
        return lectureService.find(lectureId);
    }

    @GetMapping("/lecture")
    public List<Lecture> category(@RequestParam("category") LectureCategory category) {
        return lectureService.findByCategory(category);
    }
}
