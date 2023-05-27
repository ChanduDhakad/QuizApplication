package com.Heliverse.services;

import java.util.List;

import com.Heliverse.exception.QuizException;
import com.Heliverse.model.Quiz;

public interface QuizService {

	
	 Quiz createQuiz(Quiz quiz)throws QuizException;
	    Quiz getActiveQuiz()throws QuizException;
	    String getQuizResultById(Integer id)throws QuizException;
	    List<Quiz> getAllQuizzes()throws QuizException;
}
