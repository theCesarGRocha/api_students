package com.example.controller;

import com.example.persistence.models.Lecture;
import com.example.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LectureController {
    @Autowired
    LectureService lectureService;

    @PostMapping("/lecture/{lecture}")
    public ResponseEntity<?> saveLecture(@PathVariable Lecture lecture) {
        try {
            lectureService.saveLecture(lecture);
            return ResponseEntity.ok("Lecture was save successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Save Lecture.");
        }

    }

    @DeleteMapping("/lecture/{id}")
    public ResponseEntity<?>  deleteStudent(@PathVariable Integer id){
        try {
            Lecture l = lectureService.getLectureById(id);
            if(l != null){
                lectureService.deleteLecture(l);
            }
            return ResponseEntity.ok("Lecture was deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Delete Lecture.");
        }

    }

    @GetMapping("/allLectures")
    public ResponseEntity<List<Lecture>> getAllStudents(){
        try {
            List<Lecture> students = lectureService.getAllLectures();
            return ResponseEntity.ok().body(students);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
    @GetMapping("/lecture/{id}")
    public ResponseEntity<Lecture> getStudentById(@PathVariable Integer id){
        try {
            Lecture lecture = lectureService.getLectureById(id);
            return ResponseEntity.ok().body(lecture);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
