package com.deni.test.firstone.repositories;

import com.deni.test.firstone.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>{
}
