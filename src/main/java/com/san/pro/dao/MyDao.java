package com.san.pro.dao;

import com.san.pro.model.User;
import com.san.pro.util.MyMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;
import org.skife.jdbi.v2.unstable.BindIn;

import java.util.List;

/**
 * Created by sandeepkumar.s on 10/27/2015.
 */
@UseStringTemplate3StatementLocator
@RegisterMapper(MyMapper.class)
public interface MyDao {
    @SqlUpdate("CREATE table users (id bigint(20) AUTO_INCREMENT primary key, name varchar(100))")
    void createTable();

    @SqlUpdate("INSERT INTO users (id, name) values (:id, :name)")
    @GetGeneratedKeys
    Long insert(@BindBean User user);

    @SqlQuery("SELECT * FROM users WHERE id = :id")
    User findById(@Bind("id") Long id);

    @SqlQuery("SELECT id, name from users WHERE name = :name")
    User findByName(@Bind("name") String name);

    @SqlQuery("SELECT * FROM users")
    List<User> findAll();

    @SqlUpdate("UPDATE users SET name = :name WHERE id = :id")
    long update(@BindBean User user);

    @SqlQuery("SELECT * FROM users WHERE id in (<usersID>)")
    List<User> findIN(@BindIn("usersID") List<Long> usersID);

    @SqlUpdate("DELETE FROM users WHERE id = :id")
    void delete(@Bind("id") Long id);
}