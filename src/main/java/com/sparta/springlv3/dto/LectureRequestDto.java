package com.sparta.springlv3.dto;

import com.sparta.springlv3.entity.LectureCategory;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LectureRequestDto {
    private String name;
    private int cost;
    private String description;
    private LectureCategory category;
    private Long tutorId;
}
