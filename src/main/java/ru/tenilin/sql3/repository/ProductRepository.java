package ru.tenilin.sql3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private static final String QUERY_FILE_NAME = "get_products_by_name.sql";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String query = read(QUERY_FILE_NAME);

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return namedParameterJdbcTemplate.queryForList(query, Collections.singletonMap("name", "Sergey"), String.class);
    }
}
