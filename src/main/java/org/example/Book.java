package org.example;

import lombok.Data;
import lombok.NonNull;

@Data
public class Book {
    @NonNull
    private Integer id;
    @NonNull
    private String title;
}
