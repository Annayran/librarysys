<<<<<<< HEAD
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
=======
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
>>>>>>> eb09ba9cc079b7c7df9570e34ee46ccc5338f0e0
