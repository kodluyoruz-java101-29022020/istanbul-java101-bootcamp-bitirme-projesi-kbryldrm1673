package com.spring.boot.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "author")
public class Authors {
	
	@Id
	@Column(name = "author_no")
	private Long authorNo;
	
	@Column(name = "book_author")
	private String  bookAuthor;
	
    /*
	@ManyToMany(mappedBy = "bookAuthors", fetch = FetchType.LAZY)
	private List<Book> books;*/
	
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "book_author",
	  joinColumns = @JoinColumn(name = "author_no"), 
	  inverseJoinColumns = @JoinColumn(name = "book_no"))
	    private List<Book> books;
	

	public Long getAuthorNo() {
		return authorNo;
	}


	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
