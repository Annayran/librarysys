package com.libary.system.util;

import com.libary.system.domain.Book;

public class BookCreator {

    public static Book createBookToBeSaved() {
        return Book.builder()
                .title("")
                .isbn("")
                .author("")
                .description("")
                .build();
    }

    public static Book createValidBook() {
        return Book.builder()
                .title("")
                .isbn("")
                .author("")
                .description("")
                .id(1L)
                .build();
    }

    public static Book createValidUpdatedBook() {
        return Book.builder()
                .title("")
                .isbn("")
                .author("")
                .description("")
                .id(1L)
                .build();
    }


}
