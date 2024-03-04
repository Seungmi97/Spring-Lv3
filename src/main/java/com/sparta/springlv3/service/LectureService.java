package com.sparta.springlv3.service;

import com.sparta.springlv3.dto.LectureRequestDto;
import com.sparta.springlv3.dto.LectureResponseDto;
import com.sparta.springlv3.dto.TutorRequestDto;
import com.sparta.springlv3.dto.TutorResponseDto;
import com.sparta.springlv3.entity.Lecture;
import com.sparta.springlv3.entity.LectureCategory;
import com.sparta.springlv3.entity.Tutor;
import com.sparta.springlv3.repository.LectureRepository;
import com.sparta.springlv3.repository.TutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final TutorRepository tutorRepository;

    public LectureService(LectureRepository lectureRepository, TutorRepository tutorRepository) {
        this.lectureRepository = lectureRepository;
        this.tutorRepository = tutorRepository;
    }

    public LectureResponseDto register(LectureRequestDto requestDto) {
        Tutor tutor = tutorRepository.findById(requestDto.getTutorId()).orElseThrow();
        Lecture lecture = new Lecture(requestDto, tutor);

        lectureRepository.save(lecture);

        return new LectureResponseDto(lecture);
    }

    @Transactional
    public LectureResponseDto update(Long lectureId, LectureRequestDto requestDto) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("강의 정보가 존재하지 않습니다.")
        );

        lecture.update(requestDto);

        return lecture.of();
    }

    public LectureResponseDto find(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("강의 정보가 존재하지 않습니다.")
        );

        return lecture.of();
    }

    public List<Lecture> findByCategory(LectureCategory category) {
        try {
            return lectureRepository.findAllByCategory(category).stream().sorted(Comparator.comparing(Lecture::getRegisteredAt).reversed()).collect(Collectors.toList());
        } catch (Exception e) {
            throw new NullPointerException(e.toString());
        }
    }
}
