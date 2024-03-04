package com.sparta.springlv3.repository;

import com.sparta.springlv3.entity.Lecture;
import com.sparta.springlv3.entity.LectureCategory;
import com.sparta.springlv3.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByTutor(Tutor tutor);
    List<Lecture> findAllByCategory(LectureCategory category);
}
