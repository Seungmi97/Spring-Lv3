package com.sparta.springlv3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int cost;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private int tutorId;
    @Column
    private LocalDateTime registeredAt;

    public Lecture(String name, int cost, String description, String category, int tutorId, LocalDateTime registeredAt) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.category = category;
        this.tutorId = tutorId;
        this.registeredAt = registeredAt;
    }
}
