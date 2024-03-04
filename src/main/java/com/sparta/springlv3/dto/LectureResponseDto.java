package com.sparta.springlv3.dto;

import com.sparta.springlv3.entity.Lecture;
import com.sparta.springlv3.entity.LectureCategory;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LectureResponseDto {
    private String name;
    private int cost;
    private String description;
    private LectureCategory category;
    private Long tutorId;
    private LocalDateTime registeredAt;

    public LectureResponseDto(Lecture lecture) {
        this.name = lecture.getName();
        this.cost = lecture.getCost();
        this.description = lecture.getDescription();
        this.category = lecture.getCategory();
        this.tutorId = lecture.getTutor().getId();
        this.registeredAt = lecture.getRegisteredAt();
    }

    @Builder
    public LectureResponseDto(String name, int cost, String description, LectureCategory category, Long tutorId, LocalDateTime registeredAt) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.category = category;
        this.tutorId = tutorId;
        this.registeredAt = registeredAt;
    }
}
