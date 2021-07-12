package com.spacey.qz.exception;

/**
 * Throws when quiz id does not exist
 * @author Spacey4uq
 *
 */
public class QuizNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizNotFoundException(String msg) {
		super(msg);
	}
}
