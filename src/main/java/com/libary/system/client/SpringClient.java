package com.libary.system.client;

import com.libary.system.domain.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {

        //Search book in application
        ResponseEntity<Book> entity = new RestTemplate().getForEntity("http://localhost:8080/books/{id}", Book.class,2);
        log.info(entity);

        Book object = new RestTemplate().getForObject("http://localhost:8080/books/{id}", Book.class,2);
        log.info(object);

        //@formatter:off
        ResponseEntity<List<Book>> exchange = new RestTemplate().exchange("http://localhost:8080/books/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});
        //@formatter:on
        log.info(exchange.getBody());

        //Save book in application
        Book addBook = Book.builder().title("").isbn("").author("").description("").build();
        ResponseEntity<Book> bookSaved = new RestTemplate().exchange("http://localhost:8080/books/",
                HttpMethod.POST,
                new HttpEntity<>(addBook, createJsonHeader()),
                Book.class);

        log.info("saved book {}", bookSaved);

        //Update book in application
        Book bookToBeUpdated = bookSaved.getBody();
        bookToBeUpdated.setTitle("");
        bookToBeUpdated.setAuthor("");
        bookToBeUpdated.setIsbn("");
        bookToBeUpdated.setDescription("");

        ResponseEntity<Void> bookUpdated = new RestTemplate().exchange("http://localhost:8080/books/",
                HttpMethod.PUT,
                new HttpEntity<>(bookToBeUpdated, createJsonHeader()),
                Void.class);

        log.info(bookUpdated);

        //Delete book in application
        ResponseEntity<Void> bookDeleted = new RestTemplate().exchange("http://localhost:8080/books/",
                HttpMethod.DELETE,
                null,
                Void.class,
                bookToBeUpdated.getId());

        log.info(bookDeleted);

    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
    }


