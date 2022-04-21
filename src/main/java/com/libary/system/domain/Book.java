<<<<<<< HEAD
package com.libary.system.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Book title cannot be empty")
    private String title;

    @NotEmpty(message = "Book isbn cannot be empty")
    private String isbn;

    @NotEmpty(message = "Author name cannot be empty")
    private String author;
    private String description;


}
=======
package com.libary.system.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Book title cannot be empty")
    private String title;

    @NotEmpty(message = "Book isbn cannot be empty")
    private String isbn;

    @NotEmpty(message = "Author name cannot be empty")
    private String author;
    private String description;


}
>>>>>>> eb09ba9cc079b7c7df9570e34ee46ccc5338f0e0
