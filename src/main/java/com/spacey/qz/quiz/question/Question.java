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
//	@ManyToOne(optional = false) // 'false' indicates this cannot live without its parent (Quiz)
//	@JoinColumn(name = "quiz_id")
//	Quiz quiz;
	

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", options=" + options + ", correctOption=" + correctOption
				+ ", points=" + points + ", quizId=" + quizId + "]";
	}

}
