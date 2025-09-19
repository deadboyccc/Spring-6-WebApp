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

@Component
@Slf4j
@RequiredArgsConstructor
public class DataBootstrap implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        // create 2 books per 2 authors per 1 pub - > will postgres them so the delete
        bookRepository.deleteAll();
        publisherRepository.deleteAll();
        authorRepository.deleteAll();

        Book book1 = Book.builder().title("book1").isbn("11111").build();
        Book book2 = Book.builder().title("book2").isbn("22222").build();

        Author author1 = Author.builder().firstName("authorOneFirstName").lastName("authorOneLastName").build();
        Author author2 = Author.builder().firstName("authorTwoFirstName").lastName("authorTwoLastName").build();

        Publisher publisher = Publisher.builder()
                .city("Baghdad")
                .zipCode("10001").build();


        // many to many book<->authors
        book1.getAuthors().add(author1);
        book2.getAuthors().add(author2);

        author1.getBooks().add(book1);
        author2.getBooks().add(book2);
        // --

        // oneToMany publisher to books
        publisher.getBooks().add(book1);
        publisher.getBooks().add(book2);

        book1.setPublisher(publisher);
        book2.setPublisher(publisher);
        //--
        bookRepository.save(book1);
        bookRepository.save(book2);
        authorRepository.save(author1);
        authorRepository.save(author2);
        publisherRepository.save(publisher);

        log.debug("_".repeat(20));
        log.debug("Book count: " + bookRepository.count());
        log.debug("Author count: " + authorRepository.count());
        log.debug("Publisher count: " + publisherRepository.count());

        log.debug("_".repeat(20));


    }
}
