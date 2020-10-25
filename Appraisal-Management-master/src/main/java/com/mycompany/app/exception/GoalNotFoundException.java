package com.mycompany.app.exception;

public class GoalNotFoundException extends Exception {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoalNotFoundException(int id) {
		super("Goal id is not found : "+id);
	}
}
