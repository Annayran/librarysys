package com.libary.system.service;

import com.libary.system.domain.Book;
import com.libary.system.exception.BadRequestException;
import com.libary.system.mapper.BookMapper;
import com.libary.system.repository.BookRepository;
import com.libary.system.requests.BookPostRequestBody;
import com.libary.system.requests.BookPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Page<Book> listAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public List<Book> listAllNonPageable() {
        return bookRepository.findAll();
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book findByIdOrThrowBadRequestException(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Book not Found"));
    }

    @Transactional
    public Book save(BookPostRequestBody bookPostRequestBody) {
        return bookRepository.save(BookMapper.INSTANCE.toBook(bookPostRequestBody));
    }

    public void delete(long id) {
        bookRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(BookPutRequestBody bookPutRequestBody) {
        Book savedBook = findByIdOrThrowBadRequestException(bookPutRequestBody.getId());
        Book book = BookMapper.INSTANCE.toBook(bookPutRequestBody);
        book.setId(savedBook.getId());
        bookRepository.save(book);
    }


}
