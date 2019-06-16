package com.ivanovev.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
	@Autowired BookRepository repo;
	
	public void save(Book book) {
		repo.save(book);
	}
	
	public List<Book> listAll() {
		return (List<Book>) repo.findAll();
	}
	
	public Book get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Book> search(String keyword) {
		return repo.search(keyword);
	}
}
