package com.spacey.qz.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spacey.qz.exception.QuizNotFoundException;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;

	@GetMapping("/{quizId}")
	public Quiz fetchQuiz(@PathVariable("quizId") Long quizId) {
		return quizService.fetchQuiz(quizId);
	}

	@PostMapping("/")
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		return quizService.createQuiz(quiz);
	}
	
	@DeleteMapping("/{quizId}")
	public ResponseEntity<String> deleteQuiz(@PathVariable("quizId") Long quizId) {
		quizService.deleteQuiz(quizId);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@ExceptionHandler(QuizNotFoundException.class) // (optional to list exceptions here) takes an exception or a
														// list of exceptions as an argument that
														// we want to handle in the defined method
	@ResponseStatus(code = HttpStatus.NOT_FOUND) // Also, the annotation @ResponseStatus(HttpStatus.NOT_FOUND) on the
	// handler method is not required as the HTTP status passed into the
	// ResponseEnity will take precedence, but we have kept it anyway
	// for the same readability reasons.
	public ResponseEntity<String> handleQuizNotFoundException(QuizNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{}");
	}

}
