package com.mycomp.exboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExController {

	@RequestMapping(value = "/example", method=RequestMethod.GET)
	public String getExample() {
		return "Example";
	}
	
}
