package com.spacey.qz.exception;

/**
 * Throws when quiz/question name is not valid
 * @author Spacey4uq
 *
 */
public class IllegalNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalNameException(String msg) {
		super(msg);
	}
}
