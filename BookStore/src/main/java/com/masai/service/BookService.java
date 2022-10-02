package com.masai.service;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;


public interface BookService {

	public Book saveBook(Book book);
	public Book getBookById(Integer bookId) throws BookNotFoundException;
	
}
