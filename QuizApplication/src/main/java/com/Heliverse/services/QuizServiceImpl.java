package com.Heliverse.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Heliverse.exception.QuizException;
import com.Heliverse.model.Quiz;
import com.Heliverse.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	
	 @Autowired
    public  QuizRepository quizRepository;

  

    @Override
    public Quiz createQuiz(Quiz quiz) throws QuizException {
       

                   quiz.setStatus("active");
                   quiz.setEndDate(LocalDateTime.now().plusMinutes(5));
                   return quizRepository.save(quiz);
       
    }
    


    @Override
    public Quiz getActiveQuiz() throws QuizException {
      
            LocalDateTime currentDateTime = LocalDateTime.now();
            Optional<Quiz> activeQuiz = quizRepository.findByStartDateBeforeAndEndDateAfter(currentDateTime, currentDateTime);
            if (activeQuiz.isPresent()) {
                // Check and update the status of the active quiz
                Quiz quiz = activeQuiz.get();
                if (currentDateTime.isBefore(quiz.getStartDate())) {
                    quiz.setStatus("inactive");
                } else if (currentDateTime.isAfter(quiz.getEndDate())) {
                    quiz.setStatus("finished");
                } else {
                    quiz.setStatus("active");
                }
               
                quizRepository.save(quiz);
            }
               
                else throw new QuizException("Active quiz not found");
             return activeQuiz.get();
    }
    

    
    
    

    @Override
    public String getQuizResultById(Integer id) throws QuizException {
      
    	          String  message="Quiz is Currently is going on ";
                   Optional<Quiz> opt=quizRepository.findById(id);
                   if(opt.isEmpty()) {
                	  throw new QuizException("Failed to get quiz result with Given Id "+ id);
                   }
                   LocalDateTime endTime = opt.get().getEndDate();
                   LocalDateTime currentTime = LocalDateTime.now();

                   if (currentTime.isBefore(endTime.plusMinutes(5))) {
                       throw new QuizException("Quiz result is not yet available");
                   }
    	    
                     
            return "Result is "+ opt.get().getRightAnswer();

    }

    @Override
    public List<Quiz> getAllQuizzes() throws QuizException {
     
    	List<Quiz>Quizzes= quizRepository.findAll();
    	if(Quizzes.isEmpty())   throw new QuizException("Quizzes   List is Empty ");
    	else return Quizzes;
       
    }
}
