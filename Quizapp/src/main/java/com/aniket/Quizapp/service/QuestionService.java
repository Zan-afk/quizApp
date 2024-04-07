package com.aniket.Quizapp.service;

import com.aniket.Quizapp.dao.QuestionDao;
import com.aniket.Quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //we can also write @component to get instance of obj
public class QuestionService {


    @Autowired
    QuestionDao questionDao;
    public ResponseEntity <List<Question>> getAllQuestions() {

        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {

        try {
            questionDao.save(question);
            return new ResponseEntity<>("successfully added", HttpStatus.CREATED);


        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Error occur", HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> deleteQuestion(int id) {

        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.NO_CONTENT);


        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Error occur", HttpStatus.BAD_REQUEST);


    }

    public String updateQuestion(Question question) {

        questionDao.save(question);
        return "successfully updated";
    }
}
