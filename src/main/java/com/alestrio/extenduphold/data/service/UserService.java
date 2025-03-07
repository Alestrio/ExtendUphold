package com.alestrio.extenduphold.data.service;

import com.alestrio.extenduphold.data.entity.User;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class responsible for the actions in the database. At this point, no secret data is left unencrypted,
 * this allows to avoid putting secret data in the database.
 */
@Component
public class UserService {
    JdbcTemplate jdbcTemplate;
    private User user;

    public UserService() {
        MysqlDataSource data = new MysqlDataSource();
        data.setServerName("localhost");
        data.setPortNumber(3306);
        data.setUser("test");
        data.setPassword("test");
        data.setDatabaseName("extenduphold");

        DataSource dataSource;
        jdbcTemplate = new JdbcTemplate(data);
    }

    public User findByUsername(String name) {
        List<User> users = findAll();

        users.forEach(e -> {
            if (e.getUsername().equals(name)) {
                this.user = e;
            }
        });
        if (user != null) {
            return this.user;
        } else {
            return new User();
        }
    }
    public List<User> findAll() {
        try {
            return jdbcTemplate.query("SELECT username, email, password, photo_url, last_connexion," +
                    " strategy_table, copy_token, tx_table, encrypted_apik FROM users",
                    (rs, rowNum) -> new User(rs.getString("username"), rs.getString("email"),
                    rs.getString("password"), rs.getString("photo_url"),
                    rs.getDate("last_connexion"), rs.getString("strategy_table"),
                    rs.getString("copy_token"), rs.getString("tx_table"),
                    rs.getString("encrypted_apik")));

        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public int addUser(User user){
        try {
            this.createStrat(user.getStrategy_table());
            this.createTx(user.getTx_table());
            return jdbcTemplate.update("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    user.getUsername(), user.getEmail(), user.getPassword(),
                    user.getPhoto_url(), user.getLast_connexion(), user.getStrategy_table(),
                    user.getCopy_token(), user.getTx_table(), user.getEncrypted_apik());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int createTx(String tx_table) {
        try{
            return jdbcTemplate.update("create table " + tx_table + "\n" +
                    "(\n" +
                    "pair text not null,\n" +
                    "amount text not null,\n" +
                    "sold_or_bought text not null\n" +
                    ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    private int createStrat(String id) {
        try{
            return jdbcTemplate.update("create table " + id + "\n" +
                    "(\n" +
                    "\tpair text not null,\n" +
                    "\tsteps longtext null,\n" +
                    "\tstoploss text not null\n" +
                    ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
