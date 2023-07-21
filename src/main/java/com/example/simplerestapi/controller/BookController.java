package com.example.simplerestapi.controller;

import com.example.simplerestapi.model.Book;
import com.example.simplerestapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/books")

public class BookController {
    private final BookService bookService;

    @GetMapping
    @ResponseStatus(FOUND)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(FOUND)
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public void putBook(@PathVariable("id") Integer id, @RequestBody Book updateBook) {
        bookService.updateBookWithPut(id, updateBook);
    }

    @PatchMapping("/{id}")
    public void patchBook(@PathVariable("id") Integer id, @RequestBody Book updateBook) {
        bookService.updateBookWithPatch(id, updateBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
    }


}
