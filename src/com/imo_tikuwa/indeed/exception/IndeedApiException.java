package com.imo_tikuwa.indeed.exception;

/**
 * IndeedApi内で発生した例外をまとめた例外
 * @author tikuwa
 *
 */
public class IndeedApiException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IndeedApiException(String str) {
		super(str);
	}
}
