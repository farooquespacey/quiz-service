package com.spacey.qz.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacey.qz.exception.IllegalNameException;
import com.spacey.qz.exception.QuizNotFoundException;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;
	
	public Quiz fetchQuiz(Long quizId) {
		Quiz q = quizRepository.findOne(quizId);
		if(q != null) return q;
		else throw new QuizNotFoundException("quiz does not exist");
	}

	public Quiz createQuiz(Quiz quiz) {
		if(quiz.getName().isEmpty()) throw new IllegalNameException("name should not be empty!");
		return quizRepository.save(quiz);
	}

	public void deleteQuiz(Long quizId) {
		quizRepository.delete(quizId);
	}

}
