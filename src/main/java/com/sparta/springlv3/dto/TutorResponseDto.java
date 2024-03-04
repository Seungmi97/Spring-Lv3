package com.sparta.springlv3.dto;

import com.sparta.springlv3.entity.Tutor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TutorResponseDto {
    private String name;
    private int career;
    private String company;
    private String phoneNumber;
    private String description;

    public TutorResponseDto(Tutor tutor) {
        this.name = tutor.getName();
        this.career = tutor.getCareer();
        this.company = tutor.getCompany();
        this.phoneNumber = tutor.getPhoneNumber();
        this.description = tutor.getDescription();
    }

    @Builder
    public TutorResponseDto(String name, int career, String company, String phoneNumber, String description) {
        this.name = name;
        this.career = career;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }
}
