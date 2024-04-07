package com.aniket.Quizapp.controller;

import com.aniket.Quizapp.model.Question;
import com.aniket.Quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("question") //for spacific controller in app there are more than one controller so by using this anno  
    public class QuestionController {

        @Autowired
        QuestionService questionService;

        @GetMapping("allQuestions")
         public ResponseEntity<List<Question>> getAllQuestions(){

          // public List<Question> getAllQuestions(){

            return questionService.getAllQuestions();
            //return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.OK);//this will give response in json with status code message

        }


        @GetMapping("category/{category}")
        public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){ //pathvariable assign getmapping category to this category

            return questionService.getQuestionsByCategory(category);

        }


        @PostMapping("add")
            public ResponseEntity<String> addQuestion(@RequestBody Question question){

            return  questionService.addQuestion(question);

        }

        @DeleteMapping("delete/{id}")
        public ResponseEntity<String> addQuestion(@PathVariable int id){

            return  questionService.deleteQuestion(id);
        }

        @PutMapping ("update")
        public String updateQuestion(@RequestBody Question question){

            return  questionService.updateQuestion(question);
        }

    }
