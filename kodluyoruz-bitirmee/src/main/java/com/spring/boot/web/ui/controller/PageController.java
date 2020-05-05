package com.spring.boot.web.ui.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boot.dao.entity.Authors;
import com.spring.boot.dao.entity.Book;
import com.spring.boot.service.BookService;
import com.spring.boot.service.model.BookContext;
import com.spring.boot.service.model.BookProfile;

@Controller
@RequestMapping("/pages")
public class PageController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getAllBook(Model model) {

		List<Book> book = bookService.getAllBookList();
		model.addAttribute("books", book);

		return "thyme_book_list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String getBookSavePage(BookContext bookContext) {

		return "thyme_book_save";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(BookContext bookContext, BindingResult result, Model model) {

		bookService.save(bookContext);

		model.addAttribute("books", bookService.getAllBookList());

		return "thyme_book_list";
	}


	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String getAuthorList(Model model) {
		
		List<Authors> authors=bookService.getAllAuthorList();
		
		model.addAttribute("books", authors);
		
		return "thyme_book_author";
	}

}
