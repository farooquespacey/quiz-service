package com.spacey.qz.quiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacey.qz.exception.IllegalNameException;
import com.spacey.qz.exception.QuestionNotFoundException;
import com.spacey.qz.exception.QuizNotFoundException;
import com.spacey.qz.quiz.QuizRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	QuestionRepository quesRepository;
	
	public Question fetchQues(Long quesId) {
		Question q = quesRepository.findOne(quesId);
		if(q != null) return q;
		else throw new QuestionNotFoundException("question does not exist");
	}

	public Question createQuiz(Question ques) {
		if(ques.getName().isEmpty()) throw new IllegalNameException("name should not be empty!");
		if(quizRepository.findOne(ques.getQuizId()) != null) {
			return quesRepository.save(ques);			
		} else {
			throw new QuizNotFoundException("provided quiz id does not exist!");
		}
	}

}
