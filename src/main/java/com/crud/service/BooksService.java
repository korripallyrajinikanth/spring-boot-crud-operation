package com.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Books;
import com.crud.repository.BooksRepository;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    public Books getBooksById(int id) {
        return booksRepository.findById(id).get();
    }

    public List<Books> saveOrUpdate(List<Books> books) {
        List<Books> list_books = new ArrayList<>();
        for (Books s:books
             ) {
           Books b= booksRepository.save(s);
            list_books.add(b);
        }
return list_books;

    }


    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    //updating a record
    public void update(Books books, int bookid) {
        booksRepository.save(books);
    }
}