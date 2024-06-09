package com.database.Spring_PostGres;

import com.database.Spring_PostGres.domain.Author;
import com.database.Spring_PostGres.domain.Book;

public final class TestDataUtil {

    private TestDataUtil(){}


    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .age(15)
                .name("testname")
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .title("Hello World")
                .isbn("123456")
                .authorId(1L)
                .build();
    }
}
