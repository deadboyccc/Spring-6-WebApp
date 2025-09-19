package dev.dead.spring6webapp.bootstrap;

import dev.dead.spring6webapp.domain.Author;
import dev.dead.spring6webapp.domain.Book;
import dev.dead.spring6webapp.domain.Publisher;
import dev.dead.spring6webapp.repository.AuthorRepository;
import dev.dead.spring6webapp.repository.BookRepository;
import dev.dead.spring6webapp.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataBootstrap implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) {

        // clear existing data
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();

        // create authors
        Author author1 = Author.builder()
                .firstName("authorOneFirstName")
                .lastName("authorOneLastName")
                .build();

        Author author2 = Author.builder()
                .firstName("authorTwoFirstName")
                .lastName("authorTwoLastName")
                .build();

        // create publisher
        Publisher publisher = Publisher.builder()
                .city("Baghdad")
                .zipCode("10001")
                .build();

        // create books
        Book book1 = Book.builder()
                .title("book1")
                .isbn("11111")
                .publisher(publisher)
                .build();

        Book book2 = Book.builder()
                .title("book2")
                .isbn("22222")
                .publisher(publisher)
                .build();

        // set relationships
        book1.getAuthors().add(author1);
        book2.getAuthors().add(author2);

        author1.getBooks().add(book1);
        author2.getBooks().add(book2);

        publisher.getBooks().add(book1);
        publisher.getBooks().add(book2);

        // --- save in correct order ---
        publisherRepository.save(publisher);
        authorRepository.saveAll(List.of(author1, author2));
        bookRepository.saveAll(List.of(book1, book2));

        // logs
        log.debug("---------- Bootstrap Data Loaded ----------");
        log.debug("Book count: {}", bookRepository.count());
        log.debug("Author count: {}", authorRepository.count());
        log.debug("Publisher count: {}", publisherRepository.count());
        log.debug("-------------------------------------------");
    }
}
