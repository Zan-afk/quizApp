package com.aniket.Quizapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "quiz_questions", // Specify the name of the join table
            joinColumns = @JoinColumn(name = "quiz_id"), // Foreign key column in quiz_questions table
            inverseJoinColumns = @JoinColumn(name = "question_id") // Foreign key column in question table
    )
    private List<Question> questions;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


}
