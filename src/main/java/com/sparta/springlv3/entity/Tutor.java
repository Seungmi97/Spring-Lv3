package com.sparta.springlv3.entity;

import com.sparta.springlv3.dto.TutorRequestDto;
import com.sparta.springlv3.dto.TutorResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int career;
    @Column(nullable = false)
    private String company;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String description;

    public Tutor(TutorRequestDto requestDto) {
        this.name = requestDto.getName();
        this.career = requestDto.getCareer();
        this.company = requestDto.getCompany();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.description = requestDto.getDescription();
    }

    public void update(TutorRequestDto requestDto) {
        this.career = requestDto.getCareer();
        this.company = requestDto.getCompany();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.description = requestDto.getDescription();
    }

    public TutorResponseDto of() {
        return TutorResponseDto.builder()
                .name(name)
                .career(career)
                .company(company)
                .phoneNumber(phoneNumber)
                .description(description)
                .build();
    }
}
