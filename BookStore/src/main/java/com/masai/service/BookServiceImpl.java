package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;
import com.masai.repository.BookDao;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book saveBook(Book book) {
	
		Book newBook = bookDao.save(book);
		return newBook;
	}

	@Override
	public Book getBookById(Integer bookId) throws BookNotFoundException {
		
		Optional<Book> book=bookDao.findById(bookId); 
	
		if(book.isPresent()) {
		return book.get();
		}else {
			throw new BookNotFoundException("Book does not found with id :"+bookId);
		}
		
		
	}

	@Override
	public List<Book> getAllBook() throws BookNotFoundException {
		
		List<Book> allBook = bookDao.findAll();
		if(allBook.size() == 0)
			throw  new BookNotFoundException("No book available");
		else
			return allBook;
	}

}
