package com.demo.mongodb.controller;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mongodb.entity.Book;
import com.demo.mongodb.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bservice;
	
	@PostMapping ("/addBook")
	public String saveBook(@RequestBody Book book) {
		String response = bservice.saveBook(book);
		return response;
	}
	
	@GetMapping ("/getallbooks")
	public Stream<Book> getBook(@RequestParam(required = false) String name, @RequestParam(required = false) String authorName) {
		System.out.println("Name: "+name+"  Author Name : "+authorName);
		if (name!= null) {
			System.out.println("Inside name");
			return bservice.getName(name);
		} else if (authorName != null) {
			System.out.println("Inside authorName");
			return bservice.getAuthorName(authorName);			
		} else {
			System.out.println("Insdie Else");
			return bservice.getBook().stream();	
		}		
	}
	
	@GetMapping("/getbook/{id}")
	public Optional<Book> getBook (@PathVariable Integer id){
		return bservice.getBook(id);		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		return bservice.deleteBook(id);
	}
}
