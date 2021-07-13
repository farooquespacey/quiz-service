package com.spacey.qz.quiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacey.qz.exception.IllegalNameException;
import com.spacey.qz.exception.QuestionNotFoundException;
import com.spacey.qz.exception.QuizNotFoundException;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository quesRepository;

	public Question fetchQues(Long quesId) {
		Question q = quesRepository.findOne(quesId);
		if (q != null) return q;
		else throw new QuestionNotFoundException("question does not exist");
	}

	public Question createQues(Question ques) {
		if (ques.getName().isEmpty()) 
			throw new IllegalNameException("name should not be empty!");
		try {
			return quesRepository.save(ques);	
		} catch (Exception e){
			throw new QuizNotFoundException("provided quiz id does not exist!");
		}
	}

}
