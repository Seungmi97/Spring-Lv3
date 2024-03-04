package com.sparta.springlv3.entity;

import com.sparta.springlv3.dto.LectureRequestDto;
import com.sparta.springlv3.dto.LectureResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int cost;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private LectureCategory category;

    @Column(updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registeredAt;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    public Lecture(LectureRequestDto requestDto, Tutor tutor) {
        this.name = requestDto.getName();
        this.cost = requestDto.getCost();
        this.description = requestDto.getDescription();
        this.category = requestDto.getCategory();
        this.tutor = tutor;
    }

    public void update(LectureRequestDto requestDto) {
        this.name = requestDto.getName();
        this.cost = requestDto.getCost();
        this.description = requestDto.getDescription();
        this.category = requestDto.getCategory();
    }

    public LectureResponseDto of() {
        return LectureResponseDto.builder()
                .tutorId(tutor.getId())
                .category(category)
                .cost(cost)
                .description(description)
                .name(name)
                .registeredAt(registeredAt)
                .build();
    }
}
