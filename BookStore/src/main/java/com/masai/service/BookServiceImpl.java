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

	@Override
	public Book deleteBookBybookId(Integer bookId) throws BookNotFoundException {
		
		 Book existingBook = bookDao.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found woth bookId :"+bookId));
		      bookDao.delete(existingBook);
		      return existingBook;
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {
		Optional<Book> existingBook = bookDao.findById(book.getBookId());
		if(existingBook.isPresent()) {
			Book updatedBook = existingBook.get();
			return bookDao.save(updatedBook);
		}
		else {
			throw new BookNotFoundException("No book available with given details");
		}
	}

	

}
