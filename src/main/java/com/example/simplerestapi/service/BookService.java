package com.example.simplerestapi.service;

import com.example.simplerestapi.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(Integer id) {
        log.info("ActionLog.getBookById.start id:{}", id);
        for (Book book : books) {
            if (Objects.equals(book.getId(), id)) {
                return book;
            }
        }
        log.error("ActionLog.getBookById.end id:{}", id);
        return null;

    }

    public void saveBook(Book book) {
        log.info("ActionLog.saveBook ");
        books.add(book);
    }

    public void updateBookWithPut(Integer id, Book updatebook) {
        for (Book book1 : books) {
            if (Objects.equals(book1.getId(), id)) {
                books.remove(book1.getId());
                book1.setId(updatebook.getId());
                book1.setName(updatebook.getName());
                book1.setPageNumber(updatebook.getPageNumber());
            }
        }

    }

    public void updateBookWithPatch(Integer id, Book updatebook) {
        for (Book book1 : books) {
            if (Objects.equals(book1.getId(), id)) {
                book1.setId(updatebook.getId());

            }
        }
    }


    public void deleteBook(Integer id) {
        books.removeIf(book -> Objects.equals(book.getId(), id));
    }


}
