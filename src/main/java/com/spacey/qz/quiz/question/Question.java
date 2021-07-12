package com.spacey.qz.quiz.question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	String options;
	@JsonProperty("correct_option")
	Integer correctOption;
	Integer points;
	@JsonProperty("quiz_id")
	Long quizId;
//	@ManyToOne(optional = false) // 'false' indicates this cannot live without its parent (Quiz)
//	@JoinColumn(name = "quiz_id")
//	Quiz quiz;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Integer getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(Integer correctOption) {
		this.correctOption = correctOption;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", options=" + options + ", correctOption=" + correctOption
				+ ", points=" + points + ", quizId=" + quizId + "]";
	}

}
