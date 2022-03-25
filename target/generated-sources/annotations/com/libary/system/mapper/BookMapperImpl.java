package com.libary.system.mapper;

import com.libary.system.domain.Book;
import com.libary.system.domain.Book.BookBuilder;
import com.libary.system.requests.BookPostRequestBody;
import com.libary.system.requests.BookPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-12T01:22:52-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl extends BookMapper {

    @Override
    public Book toBook(BookPostRequestBody bookPostRequestBody) {
        if ( bookPostRequestBody == null ) {
            return null;
        }

        BookBuilder book = Book.builder();

        book.title( bookPostRequestBody.getTitle() );
        book.isbn( bookPostRequestBody.getIsbn() );
        book.author( bookPostRequestBody.getAuthor() );
        book.description( bookPostRequestBody.getDescription() );

        return book.build();
    }

    @Override
    public Book toBook(BookPutRequestBody bookPutRequestBody) {
        if ( bookPutRequestBody == null ) {
            return null;
        }

        BookBuilder book = Book.builder();

        book.id( bookPutRequestBody.getId() );
        book.author( bookPutRequestBody.getAuthor() );

        return book.build();
    }
}
