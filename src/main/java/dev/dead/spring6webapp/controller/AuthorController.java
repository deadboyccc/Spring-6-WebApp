package dev.dead.spring6webapp.controller;

import dev.dead.spring6webapp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;


    @RequestMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("authors", authorService.getAuthors());
        return "authors";
    }
}
