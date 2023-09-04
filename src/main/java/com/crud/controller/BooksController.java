package com.crud.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Books;
import com.crud.service.BooksService;

@RestController
public class BooksController 
{
List<Books> books = new ArrayList<Books>();

@Autowired
BooksService booksService;

@GetMapping("/books")
public List<Books> getAllBooks() 
{
return booksService.getAllBooks();
}

@GetMapping("/book/{bookid}")
public Books getBooks(@PathVariable("bookid") int bookid) 
{
return booksService.getBooksById(bookid);
}

@DeleteMapping("/book/{bookid}")
public void deleteBook(@PathVariable("bookid") int bookid) 
{
booksService.delete(bookid);
}

@PostMapping("/book")
public List<Books> saveAllStudents(@RequestBody List<Books> books) {

    return booksService.saveOrUpdate(books);
}

@PutMapping("/books")
public List<Books> update(@RequestBody List<Books> books)
{
    List<Books> studentResponse1 = (List<Books>) booksService.saveOrUpdate(books);
    return studentResponse1;
}
}
