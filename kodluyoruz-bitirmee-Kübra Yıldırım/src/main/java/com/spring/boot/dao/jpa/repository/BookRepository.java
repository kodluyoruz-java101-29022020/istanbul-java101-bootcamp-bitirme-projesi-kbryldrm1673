package com.spring.boot.dao.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spring.boot.annotion.MethodRunTime;
import com.spring.boot.dao.entity.Authors;
import com.spring.boot.dao.entity.Book;
import com.spring.boot.service.model.BookProfile;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	@MethodRunTime(active=true)
	@Query(value = "FROM Book e WHERE e.bookNo = :bookNo")
	public Book findWithBookNo(@Param("bookNo") Long bookNo);
	
	@MethodRunTime(active=true)
	@Query(value = "SELECT MAX(e.bookNo) FROM Book e")
	public Long findMaxId();
	
	@MethodRunTime(active=true)
	@Query(value = "SELECT e FROM Book e")
	public List<Book> getAllBookList();
	
	@Query(value="SELECT e FROM Authors e")
	public List<Authors> getAuthorList();
	
	
	@MethodRunTime(active=true)
	@Query(value = "SELECT new com.spring.boot.service.model.BookProfile(emp, empDept.bookAuthor) FROM Book emp LEFT OUTER JOIN emp.bookAuthors empDept")
	public List<BookProfile> getAllBookAuthorList();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
