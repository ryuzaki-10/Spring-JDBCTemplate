package com.database.Spring_PostGres.dao.impl;

import com.database.Spring_PostGres.TestDataUtil;
import com.database.Spring_PostGres.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    BookDaoImpl underTest;

    @Test
    void CreateBookGeneratesCorrectSqlTest() {
        Book book = TestDataUtil.createTestBook();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (title,isbn,authorId) VALUES(?,?,?)"),
                eq("Hello World"),eq("123456"),eq(1L)
        );
    }

}
