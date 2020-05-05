package com.spring.boot.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1968096988464316183L;

	@Id
	@GeneratedValue
	@Column(name = "book_no")
	private Long bookNo;

	@Column(name = "book_title	")
	private String bookTitle;

	@Column(name = "publication_year")
	private String bookYear;

	@Column(name = "book_description")
	private String description;

	@Column(name = "reader_note")
	private String note;

	/*
	 * @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 * 
	 * @JoinTable( name = "book_author", joinColumns = { @JoinColumn(name =
	 * "book_no") }, inverseJoinColumns = { @JoinColumn(name = "author_no") } )
	 * private List<Authors> bookAuthors;
	 */

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "book_author",
	  joinColumns = @JoinColumn(name = "book_no"), 
	  inverseJoinColumns = @JoinColumn(name = "author_no"))
	private List<Authors> bookAuthors ;

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookYear() {
		return bookYear;
	}

	public void setBookYear(String bookYear) {
		this.bookYear = bookYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Authors> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(List<Authors> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}


}
