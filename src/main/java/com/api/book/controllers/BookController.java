package com.api.book.controllers;


import java.util.List;
import java.util.Optional;

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

import com.api.book.entities.Book;
import com.api.book.services.BookServices;



@RestController
public class BookController {
	@Autowired
	private BookServices bookService;

	@GetMapping(value="/books")
	public ResponseEntity<List<Book> > getBooks(){
		List<Book> b=this.bookService.getAllBooks();
		if(b.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(b));
	}
	
	@GetMapping(value="/books/{id}")
	public ResponseEntity<Book > getBooksById(@PathVariable("id") int id) {
		Book b=this.bookService.getBookById(id);
		if(b==null) {
			System.out.print("value null of class");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		else
			return(ResponseEntity.of(Optional.of(b)));
		
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b=this.bookService.addBook(book);
		return(b);
		}
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable int id) {
		this.bookService.delete(id);
	}
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable int id) {
		this.bookService.update(book,id);
		return book;
	}
}















