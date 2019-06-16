package com.ivanovev.book;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Book> listBook = bookService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listCustomer", listBook);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		Book book = new Book();
		model.put("book", book);
		return "new_book";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("book") Book book) {
		bookService.save(book);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editBookForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_book");
		Book book = bookService.get(id);
		mav.addObject("book", book);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
		bookService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Book> result = bookService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}
