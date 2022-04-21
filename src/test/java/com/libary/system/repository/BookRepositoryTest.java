<<<<<<< HEAD
package com.libary.system.repository;

import com.libary.system.domain.Book;
import com.libary.system.util.BookCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;


@DataJpaTest
@DisplayName("Tests for Book Repository")
@Log4j2
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;


    @Test
    @DisplayName("Save persists book when Successful")
    void save_PersistBook_WhenSuccessful() {
        Book bookToBeSaved = BookCreator.createBookToBeSaved();

        Book bookSaved = this.bookRepository.save(bookToBeSaved);

        Assertions.assertThat(bookSaved).isNotNull();

        Assertions.assertThat(bookSaved.getId()).isNotNull();

        Assertions.assertThat(bookSaved.getTitle()).isEqualTo(bookToBeSaved.getTitle());

    }

    @Test
    @DisplayName("Save updates book when Successful")
    void save_UpdateBook_WhenSuccessful() {
        Book bookToBeSaved = BookCreator.createBookToBeSaved();

        Book bookSaved = this.bookRepository.save(bookToBeSaved);

        bookSaved.setTitle("");
        bookSaved.setIsbn("");
        bookSaved.setAuthor("");
        bookSaved.setDescription("");

        Book bookUpdated = this.bookRepository.save(bookSaved);


        Assertions.assertThat(bookUpdated).isNotNull();

        Assertions.assertThat(bookUpdated.getId()).isNotNull();

        Assertions.assertThat(bookUpdated.getTitle()).isNotNull();

        Assertions.assertThat(bookUpdated.getAuthor()).isNotNull();

        Assertions.assertThat(bookUpdated.getIsbn()).isNotNull();

    }

    @Test
    @DisplayName("Delete removes book when Successful")
    void delete_RemoveBook_WhenSuccessful() {
        Book bookToBeSaved = BookCreator.createBookToBeSaved();

        Book bookSaved = this.bookRepository.save(bookToBeSaved);

        this.bookRepository.delete(bookSaved);

        Optional<Book> bookOptional = this.bookRepository.findById(bookSaved.getId());

        Assertions.assertThat(bookOptional).isEmpty();
    }

=======
package com.libary.system.repository;

import com.libary.system.domain.Book;
import com.libary.system.util.BookCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;


@DataJpaTest
@DisplayName("Tests for Book Repository")
@Log4j2
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;


    @Test
    @DisplayName("Save persists book when Successful")
    void save_PersistBook_WhenSuccessful() {
        Book bookToBeSaved = BookCreator.createBookToBeSaved();

        Book bookSaved = this.bookRepository.save(bookToBeSaved);

        Assertions.assertThat(bookSaved).isNotNull();

        Assertions.assertThat(bookSaved.getId()).isNotNull();

        Assertions.assertThat(bookSaved.getTitle()).isEqualTo(bookToBeSaved.getTitle());

    }

    @Test
    @DisplayName("Save updates book when Successful")
    void save_UpdateBook_WhenSuccessful() {
        Book bookToBeSaved = BookCreator.createBookToBeSaved();

        Book bookSaved = this.bookRepository.save(bookToBeSaved);

        bookSaved.setTitle("");
        bookSaved.setIsbn("");
        bookSaved.setAuthor("");
        bookSaved.setDescription("");

        Book bookUpdated = this.bookRepository.save(bookSaved);


        Assertions.assertThat(bookUpdated).isNotNull();

        Assertions.assertThat(bookUpdated.getId()).isNotNull();

        Assertions.assertThat(bookUpdated.getTitle()).isNotNull();

        Assertions.assertThat(bookUpdated.getAuthor()).isNotNull();

        Assertions.assertThat(bookUpdated.getIsbn()).isNotNull();

    }

    @Test
    @DisplayName("Delete removes book when Successful")
    void delete_RemoveBook_WhenSuccessful() {
        Book bookToBeSaved = BookCreator.createBookToBeSaved();

        Book bookSaved = this.bookRepository.save(bookToBeSaved);

        this.bookRepository.delete(bookSaved);

        Optional<Book> bookOptional = this.bookRepository.findById(bookSaved.getId());

        Assertions.assertThat(bookOptional).isEmpty();
    }

>>>>>>> eb09ba9cc079b7c7df9570e34ee46ccc5338f0e0
}