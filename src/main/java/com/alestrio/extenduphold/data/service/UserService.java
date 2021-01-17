package com.alestrio.extenduphold.data.service;

import com.alestrio.extenduphold.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List findAll() {
        try {
            return jdbcTemplate.query("SELECT id, username, email, password, photo_url, last_connexion," +
                    " strategy_table, copy_token, tx_table, encrypted_apik FROM users",
                    (rs, rowNum) -> new User(rs.getInt("id"),
                    rs.getString("username"), rs.getString("email"),
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
            return jdbcTemplate.update("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    user.getUsername(), user.getEmail(), user.getPassword(),
                    user.getPhoto_url(), user.getLast_connexion(), user.getStrategy_table(),
                    user.getCopy_token(), user.getTx_table(), user.getEncrypted_apik());
        } catch (Exception e) {
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
            return 0;
        }
    }
}
