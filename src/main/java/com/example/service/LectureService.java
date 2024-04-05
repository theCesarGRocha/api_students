package com.example.service;

import com.example.persistence.models.Lecture;
import com.example.persistence.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService{
    @Autowired private LectureRepository lectureRepository;


    public Lecture saveLecture(Lecture l) {
        return lectureRepository.save(l);
    }



    public void deleteLecture(Lecture l) {
        lectureRepository.delete(l);
    }


    public Lecture getLectureById(Integer id) {
        return lectureRepository.getLectureById(id);
    }

    public List<Lecture> getAllLectures(){
        return lectureRepository.findAll();
    }
}
