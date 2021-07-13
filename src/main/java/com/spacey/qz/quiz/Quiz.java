package com.spacey.qz.quiz;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.spacey.qz.quiz.question.Question;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	Long id;
	@Getter @Setter
	String name;
	@Getter @Setter
	String description;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "quizId")
	List<Question> questions;

}
