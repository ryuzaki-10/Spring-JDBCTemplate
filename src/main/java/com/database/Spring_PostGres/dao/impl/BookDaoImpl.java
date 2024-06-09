package com.database.Spring_PostGres.dao.impl;

import com.database.Spring_PostGres.dao.BookDao;
import com.database.Spring_PostGres.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (title,isbn,authorId) VALUES(?,?,?)",
                book.getTitle(),book.getIsbn(),book.getAuthorId());
    }

    @Override
    public Optional<Book> find(String isbn) {
        List<Book> results = jdbcTemplate.query("SELECT * from books WHERE isbn=? LIMIT 1",
                new BookRowMapper(),
                isbn);
        return results.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("author_id"))
                    .isbn(rs.getString("isbn"))
                    .build();

        }
    }
}
