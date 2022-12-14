package com.masai.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.service.BookService;

@RestController
public class BookController {

	@Autowired
    private BookService bookService;
	
	@PostMapping("/bookservice/books")
	public Book saveBook(@RequestBody Book book) {
		
		return  bookService.
				saveBook(book);
	}
	
	@GetMapping("bookservice/books/{bookId}")
	public Book getBookById( @PathVariable("bookId") Integer bookId ) {
		
		return bookService.getBookById(bookId);
	}
	
	@GetMapping("bookservice/books")
	public ResponseEntity<List<Book>> getAllBooks(  ) {
		
		List<Book> allBook =bookService.getAllBook();
		return new ResponseEntity<List<Book>>(allBook,HttpStatus.OK);
	}
	
	@DeleteMapping("bookservice/books/{bookId}")
	public Book deleteBook(@PathVariable("bookId") Integer bookId ) {
		Book book = bookService.deleteBookBybookId(bookId);
		return book;
	}
	
	@PutMapping("/bookservice/book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		
		Book updatedBook = bookService.updateBook(book);
		return new ResponseEntity<Book>(updatedBook,HttpStatus.ACCEPTED);
		
	}
	
	
	
}
