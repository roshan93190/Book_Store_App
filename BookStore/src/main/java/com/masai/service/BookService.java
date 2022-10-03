package com.masai.service;

import java.util.List;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;


public interface BookService {

	public Book saveBook(Book book);
	public Book getBookById(Integer bookId) throws BookNotFoundException;
	public List<Book> getAllBook() throws BookNotFoundException;
	public Book deleteBookBybookId(Integer bookId) throws BookNotFoundException;
	public Book updateBook(Book book) throws BookNotFoundException;
	
	
}
