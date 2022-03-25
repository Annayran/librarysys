package com.libary.system.controller;

import com.libary.system.domain.Book;
import com.libary.system.requests.BookPostRequestBody;
import com.libary.system.requests.BookPutRequestBody;
import com.libary.system.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("books")
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Page<Book>> list(Pageable pageable) {
        return ResponseEntity.ok(bookService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Book>> listAll() {
        return ResponseEntity.ok(bookService.listAllNonPageable());
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id) {
        return ResponseEntity.ok(bookService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/author")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(bookService.findByAuthor(author));
    }

    @GetMapping(path = "/title")
    public ResponseEntity<List<Book>> findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookService.findByTitle(title));
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody @Valid BookPostRequestBody bookPostRequestBody) {
        return new ResponseEntity<>(bookService.save(bookPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody BookPutRequestBody bookPutRequestBody) {
        bookService.replace(bookPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
