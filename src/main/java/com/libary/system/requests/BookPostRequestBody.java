package com.libary.system.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookPostRequestBody {
    @NotEmpty(message = "Book title cannot be empty")
    private String title;

    @NotEmpty(message = "Book isbn cannot be empty")
    private String isbn;

    @NotEmpty(message = "Author name cannot be empty")
    private String author;

    private String description;
}
