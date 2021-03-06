package com.libary.system.mapper;

import com.libary.system.domain.Book;
import com.libary.system.requests.BookPostRequestBody;
import com.libary.system.requests.BookPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class BookMapper {
    public static final BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    public abstract Book toBook(BookPostRequestBody bookPostRequestBody);

    public abstract Book toBook(BookPutRequestBody bookPutRequestBody);
}
