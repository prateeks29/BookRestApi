package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookServices {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		List<Book> book=(List<Book>)this.bookRepository.findAll();
		return book;
	}
	public Book getBookById(int id) {
		Book book=null;
		try{
		book=(Book)this.bookRepository.findById(id);}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	//add book
	public Book addBook(Book b) {
		Book result=this.bookRepository.save(b);
		return(result);
	}
	//delete book
	public void delete(int id) {
		try {
			this.bookRepository.deleteById(id);;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Book book,int id) {
		book.setId(id);
		this.bookRepository.save(book);
	}

}
