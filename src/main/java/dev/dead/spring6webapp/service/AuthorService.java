package dev.dead.spring6webapp.service;

import dev.dead.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> getAuthors();
}
