package com.sparta.springlv3.service;

import com.sparta.springlv3.dto.TutorRequestDto;
import com.sparta.springlv3.dto.TutorResponseDto;
import com.sparta.springlv3.entity.Tutor;
import com.sparta.springlv3.repository.TutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
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
}
