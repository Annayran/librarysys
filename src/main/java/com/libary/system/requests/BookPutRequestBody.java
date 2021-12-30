package com.libary.system.requests;

import lombok.Data;

@Data
public class BookPutRequestBody {
    private Long id;
    private String name;
}
