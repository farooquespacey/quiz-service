package com.spacey.qz.exception;

/**
 * Throws when question id does not exist
 * @author Spacey4uq
 *
 */
public class QuestionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestionNotFoundException(String msg) {
		super(msg);
	}
}
