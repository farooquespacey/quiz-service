package com.spacey.qz.quiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spacey.qz.exception.QuestionNotFoundException;
import com.spacey.qz.exception.QuizNotFoundException;
import com.spacey.qz.res.StatusResponse;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

	@Autowired
	QuestionService quesService;

	@GetMapping("/{quesId}")
	public Object fetchQues(@PathVariable("quesId") Long quesId) {
		return quesService.fetchQues(quesId);
	}

	@PostMapping("/")
	public Object createQues(@RequestBody Question ques) {
		return quesService.createQuiz(ques);
	}

	@ExceptionHandler(QuizNotFoundException.class) // (optional to list exceptions here) takes an exception or a
													// list of exceptions as an argument that
													// we want to handle in the defined method
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) // Also, the annotation @ResponseStatus(HttpStatus.NOT_FOUND) on the
	// handler method is not required as the HTTP status passed into the
	// ResponseEnity will take precedence, but we have kept it anyway
	// for the same readability reasons.
	public ResponseEntity<StatusResponse> handleQuizNotFoundException(QuizNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new StatusResponse("failure", "QNFE: " + exception.getMessage()));
	}
	
	@ExceptionHandler(QuestionNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleQuestionNotFoundException(QuestionNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("{}");
	}
}
