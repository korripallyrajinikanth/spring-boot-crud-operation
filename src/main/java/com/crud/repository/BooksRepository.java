package com.crud.repository;
import org.springframework.data.repository.CrudRepository;

import com.crud.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
