package com.spring.boot.service.model;

import java.io.Serializable;

public class BookContext implements Serializable {

	private static final long serialVersionUID = -3546324347129770450L;
	
    
	private String bookTitle;
	private String bookYear;
	private String description;
	private String note;
	
	
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

}
