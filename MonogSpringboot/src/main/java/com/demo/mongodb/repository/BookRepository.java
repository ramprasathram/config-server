package com.demo.mongodb.repository;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.demo.mongodb.entity.Book;

@EnableMongoRepositories(basePackageClasses=Book.class)
public interface BookRepository extends MongoRepository<Book, Integer>{

	
	Stream <Book> findByBookName(String name);

	Stream<Book> findByAuthorName(String authorName);

}
