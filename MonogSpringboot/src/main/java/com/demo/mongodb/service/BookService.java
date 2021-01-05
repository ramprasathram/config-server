package com.demo.mongodb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mongodb.entity.Book;
import com.demo.mongodb.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository brepsitory;
	
	private Book book1;
	public String saveBook(Book book) {
		
		book1 = brepsitory.save(book);
		if (book1 != null) {
			return "Added Book With Id: "+ book1.getId();
		} else {
			return "Book detail is not added for Id: "+ book1.getId();
		}
		
	}
	public List<Book> getBook() {		
		return brepsitory.findAll();
	}
	public Optional<Book> getBook(Integer id) {		
		return brepsitory.findById(id);
	}
	
	public String deleteBook(Integer id) {
		brepsitory.deleteById(id);		
		return "Book Delete with Id :"+id;
	}
	public Stream<Book> getName(String name) {	
		return brepsitory.findByBookName(name);
	}
	public Stream<Book> getAuthorName(String authorName) {		
		return brepsitory.findByAuthorName(authorName);
	}

}
