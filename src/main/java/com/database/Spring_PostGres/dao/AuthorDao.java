package com.database.Spring_PostGres.dao;

import com.database.Spring_PostGres.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}
