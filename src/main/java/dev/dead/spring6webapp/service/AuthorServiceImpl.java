package dev.dead.spring6webapp.service;

import dev.dead.spring6webapp.domain.Author;
import dev.dead.spring6webapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();

    }
}
