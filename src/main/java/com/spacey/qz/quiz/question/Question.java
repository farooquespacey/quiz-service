package com.spacey.qz.quiz.question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	Long id;
	@Getter @Setter
	String name;
	@Getter @Setter
	String options;
	@JsonProperty("correct_option")
	@Getter @Setter
	Integer correctOption;
	@Getter @Setter
	Integer points;
	@JsonProperty("quiz_id")
	@Getter @Setter
	Long quizId;
	
}
