package com.ivanovev.book;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	@Query(value = "SELECT c FROM Customer c WHERE c.title LIKE '%' || :keyword || '%'"
			+ " OR c.author LIKE '%' || :keyword || '%'"
			+ " OR c.genre LIKE '%' || :keyword || '%'"
			+ " OR c.description LIKE '%' || :keyword || '%'"
			+ " OR c.price LIKE '%' || :keyword || '%'")
	public List<Book> search(@Param("keyword") String keyword);
}
