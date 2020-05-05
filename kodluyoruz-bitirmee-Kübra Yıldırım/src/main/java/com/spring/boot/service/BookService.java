package com.spring.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.spring.boot.annotion.MethodRunTime;
import com.spring.boot.dao.entity.Authors;
import com.spring.boot.dao.entity.Book;
import com.spring.boot.dao.jpa.repository.BookRepository;
import com.spring.boot.service.model.BookContext;
import com.spring.boot.service.model.BookProfile;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@MethodRunTime(active = true)
	public Book findByBookNo(Long bookNo) {

		return bookRepository.findWithBookNo(bookNo);
	}

	@MethodRunTime(active = true)
	public List<Book> getAllBookList() {

		return bookRepository.getAllBookList();
	}
	
	@MethodRunTime(active=true)
	public List<BookProfile> getAllBookAuthorList() {
		
		return bookRepository.getAllBookAuthorList();
	}
	
	@MethodRunTime(active=true)
	public List<Authors> getAllAuthorList(){
		
		return bookRepository.getAuthorList();
	}
	
	

	@MethodRunTime(active = true)
	public Long save(BookContext bookContext) {

		Long maxId = bookRepository.findMaxId() + 1;

		Book book = new Book();
		book.setBookNo(maxId);
		book.setBookTitle(bookContext.getBookTitle());
		book.setBookYear(bookContext.getBookYear());
		book.setDescription(bookContext.getDescription());
		book.setNote(bookContext.getNote());

		book = bookRepository.save(book);
		
		
		if(book.getBookNo()< 0) {
			throw new RuntimeException("CUSTOM ERROR FOR ROLLBACK!");
		}
		

		return book.getBookNo();
	}

	

}
