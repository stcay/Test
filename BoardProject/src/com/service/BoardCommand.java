package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {

	public abstract void execute(HttpServletRequest request,
			HttpServletResponse response);

}