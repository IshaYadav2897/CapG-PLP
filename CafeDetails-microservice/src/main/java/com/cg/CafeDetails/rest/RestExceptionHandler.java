package com.cg.CafeDetails.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cg.CafeDetails.exception.CafeDetailsNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler {

	@ExceptionHandler(value = CafeDetailsNotFoundException.class)
	public void handleInvalidCafeDetails(HttpServletResponse response, CafeDetailsNotFoundException ex) throws IOException {
		System.out.println("Exception: " + ex.getMessage());
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
}
