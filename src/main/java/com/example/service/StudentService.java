package com.example.service;

import com.example.persistence.models.Lecture;
import com.example.persistence.models.Student;
import com.example.persistence.repository.LectureRepository;
import com.example.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LectureRepository lectureRepository;
    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }

    public boolean deleteStudent(Student s) {
        List<Lecture> lectureList = s.getLectures();
        if(lectureList.isEmpty()){
            studentRepository.delete(s);
            return true;
        }else{
            return false;
        }

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }
    public void assignLectureToStudent(Integer idStudent, Integer idLecture) {
        Lecture l = lectureRepository.getLectureById(idLecture);
        List<Lecture> lectures = new ArrayList<>();
        lectures.add(l);
        studentRepository.assignLecturesToStudent(idStudent, lectures);
    }
}
