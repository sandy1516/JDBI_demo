package com.san.pro.util;

import com.san.pro.model.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sandeepkumar.s on 10/27/2015.
 */
public class MyMapper implements ResultSetMapper<User> {
    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        return user;
    }

//    private Long resolveLong(ResultSet resultSet, String columnName) throws SQLException {
//        return resultSet.getObject(columnName) != null ? resultSet.getLong(columnName) : null;
//    }
}
