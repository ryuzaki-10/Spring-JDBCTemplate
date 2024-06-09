package com.database.Spring_PostGres.dao.impl;

import com.database.Spring_PostGres.TestDataUtil;
import com.database.Spring_PostGres.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    AuthorDaoImpl underTest;

    @Test
    public void CreateAuthorGeneratesCorrectSqlTest() {
        Author author = TestDataUtil.createTestAuthor();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id,age,name) VALUES(?,?,?)"),
                eq(1L),eq(15),eq("testname")
        );
    }

    @Test
    public void FindOneGeneratesCorrectSqlTest(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(eq("SELECT id,age,name FROM author WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L));
    }
}
