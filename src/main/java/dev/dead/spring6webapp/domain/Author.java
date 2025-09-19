package dev.dead.spring6webapp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    // mapped by authors attribute in the book entity
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "authors")
    private Set<Book> books=new HashSet<>();
}
