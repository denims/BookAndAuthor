package com.deni.test.firstone.bootstrap;

import com.deni.test.firstone.model.Author;
import com.deni.test.firstone.model.Book;
import com.deni.test.firstone.model.Publisher;
import com.deni.test.firstone.repositories.AuthorRepository;
import com.deni.test.firstone.repositories.BookRepository;
import com.deni.test.firstone.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    public void init(){

        Author author1 = new Author("Test1","Test2");
        Publisher publisher1 = new Publisher("Test Name","Test address");
        Book book1 = new Book("Test1","1221",publisher1);
        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        Publisher publisher2 = new Publisher("Test Name 2","Test address 2");
        Book book2 = new Book("Test1","1221",publisher2);
        Author author2 = new Author("Test1","Test2");
        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);
        authorRepository.save(author1);
        authorRepository.save(author2);

        bookRepository.save(book1);
        bookRepository.save(book2);

    }
}
