package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dao.entity.Authors;
import com.spring.boot.dao.entity.Book;
import com.spring.boot.service.BookService;
import com.spring.boot.service.model.BookContext;
import com.spring.boot.service.model.BookProfile;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book findByEmpNo(@PathVariable("id") Long id) {

		return bookService.findByBookNo(id);
	}

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public List<Book> getAllBookList() {

		return bookService.getAllBookList();
	}

	@RequestMapping(value = "/author/list", method = RequestMethod.GET)
	public List<Authors> getAuthorList() {
		return bookService.getAllAuthorList();
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Long save(@RequestBody BookContext bookContext) {

		return bookService.save(bookContext);
	}

	@RequestMapping(value = "/book/author/list", method = RequestMethod.GET)
	public ResponseEntity<List<BookProfile>> getAllEmployeeProfileList() {

		List<BookProfile> profiles = bookService.getAllBookAuthorList();

		ResponseEntity<List<BookProfile>> response = new ResponseEntity<List<BookProfile>>(profiles,
				HttpStatus.UNAUTHORIZED);

		return response;
	}

	/*
	 * @RequestMapping(value = "/book/author/list", method = RequestMethod.GET)
	 * public List<BookProfile> getAllBookAuthorList() {
	 * 
	 * return bookService.getAllBookAuthorList();
	 * 
	 * }
	 */

}
