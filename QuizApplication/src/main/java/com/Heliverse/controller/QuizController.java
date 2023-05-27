package com.Heliverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Heliverse.exception.QuizException;
import com.Heliverse.model.Quiz;
import com.Heliverse.services.QuizService;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

	  @Autowired
    public QuizService quizService;

  
  

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) throws QuizException {
      Quiz createdQuiz = quizService.createQuiz(quiz);
       return new ResponseEntity<Quiz>(createdQuiz ,HttpStatus.CREATED);
       
    }


    
    @GetMapping("/active")
    public ResponseEntity<Quiz> getActiveQuiz() throws QuizException {
     Quiz activeQuiz = quizService.getActiveQuiz();
	    return new ResponseEntity<Quiz>(activeQuiz ,HttpStatus.OK);
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<String> getQuizResultById(@PathVariable("id") Integer id) throws QuizException {
     String activeQuiz = quizService.getQuizResultById(id);
	   return new ResponseEntity<String>(activeQuiz ,HttpStatus.OK);
        
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() throws QuizException {
      
        
        List<Quiz> quizzes  = quizService.getAllQuizzes();
 	   return new ResponseEntity<List<Quiz>>(quizzes ,HttpStatus.OK);
    }
}
