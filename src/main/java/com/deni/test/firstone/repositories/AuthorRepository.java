package com.deni.test.firstone.repositories;

import com.deni.test.firstone.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
