package com.mycomp.exboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.exboard.entity.Book;
import com.mycomp.exboard.service.BookService;

@RestController
public class ExController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/example", method=RequestMethod.GET)
	public String getExample() {
		return "Example";
	}
	
	@RequestMapping(value = "/book", method=RequestMethod.GET)
	public List<Book> getBookList() throws Exception {
		List<Book> books = bookService.selectBook();
		
		return books;
	}
	
}
