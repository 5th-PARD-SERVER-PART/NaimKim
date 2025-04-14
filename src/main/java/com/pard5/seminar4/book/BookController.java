package com.pard5.seminar4.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public void createBook(@RequestBody BookReq req) {
        bookService.createBook(req);
    }

    @GetMapping("/{id}")
    public BookRes readBook(@PathVariable Long id) {
        return bookService.readBook(id);
    }
}