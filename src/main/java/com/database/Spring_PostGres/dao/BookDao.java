package com.database.Spring_PostGres.dao;

import com.database.Spring_PostGres.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String id);
}
