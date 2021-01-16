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

    public void addUser(User user){
        this.createStrat(user.getStrategy_table());
        this.createTx(user.getTx_table());
    }

    private void createTx(String tx_table) {
    }

    private void createStrat(String id) {
    }
}
