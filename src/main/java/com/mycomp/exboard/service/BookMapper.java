package com.mycomp.exboard.service;

import java.util.List;

import com.mycomp.exboard.entity.Book;

public interface BookMapper {

	/* Book 목록 조회 */
	public List<Book> selectBook() throws Exception;
	
}
