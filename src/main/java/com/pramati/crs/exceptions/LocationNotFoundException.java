package com.pramati.crs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends APIExeception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocationNotFoundException(String message) {
		super(message);
	}
}
