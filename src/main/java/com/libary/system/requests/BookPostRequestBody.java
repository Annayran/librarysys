package com.libary.system.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookPostRequestBody {
    @NotEmpty(message = "The title cannot be empty")
    private String title;

    @NotEmpty(message = "The isbn cannot be empty")
    private String isbn;

    @NotEmpty(message = "The author name cannot be empty")
    private String author;

    private String description;
}
