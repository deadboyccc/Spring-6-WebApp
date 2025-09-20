package dev.dead.spring6webapp.service;

import dev.dead.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
