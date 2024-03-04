package com.sparta.springlv3.service;

import com.sparta.springlv3.dto.TutorRequestDto;
import com.sparta.springlv3.dto.TutorResponseDto;
import com.sparta.springlv3.entity.Lecture;
import com.sparta.springlv3.entity.Tutor;
import com.sparta.springlv3.repository.LectureRepository;
import com.sparta.springlv3.repository.TutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;
    private final LectureRepository lectureRepository;

    public TutorService(TutorRepository tutorRepository, LectureRepository lectureRepository) {
        this.tutorRepository = tutorRepository;
        this.lectureRepository = lectureRepository;
    }

    public TutorResponseDto register(TutorRequestDto requestDto) {
        Tutor tutor = new Tutor(requestDto);

        tutorRepository.save(tutor);

        return new TutorResponseDto(tutor);
    }

    @Transactional
    public TutorResponseDto update(Long tutorId, TutorRequestDto requestDto) {
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(
                () -> new IllegalArgumentException("강사 정보가 존재하지 않습니다.")
        );

        tutor.update(requestDto);

        return tutor.of();
    }

    public TutorResponseDto find(Long tutorId) {
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(
                () -> new IllegalArgumentException("강사 정보가 존재하지 않습니다.")
        );

        return tutor.of();
    }

    public List<Lecture> findByTutor(Long tutorId) {
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(
                () -> new IllegalArgumentException("강사 정보가 존재하지 않습니다.")
        );

        try {
            return lectureRepository.findAllByTutor(tutor).stream().sorted(Comparator.comparing(Lecture::getRegisteredAt).reversed()).collect(Collectors.toList());
        } catch (Exception e) {
            throw new NullPointerException(e.toString());
        }
    }
}
