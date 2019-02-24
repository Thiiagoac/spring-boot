package com.webstore.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1l;

	private List<FieldMessage> errors = new ArrayList<>();

	public List<FieldMessage> geterrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

	public ValidationError(Integer status, String msg, long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

}
