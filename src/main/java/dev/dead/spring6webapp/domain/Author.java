package dev.dead.spring6webapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = "books")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    // mapped by authors attribute in the book entity
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "authors")
    @Builder.Default
    private Set<Book> books=new HashSet<>();

}
