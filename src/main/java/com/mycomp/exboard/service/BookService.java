package com.mycomp.exboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.exboard.entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	public List<Book> selectBook() throws Exception {
		return bookMapper.selectBook();
	}

}
