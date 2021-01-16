package com.alestrio.extenduphold.data.entity;

import com.alestrio.extenduphold.data.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class User extends AbstractEntity {
    @NotNull
    @NotEmpty
    private String username = "";

    @Email
    @NotNull
    @NotEmpty
    private String email = "";

    public User(@NotNull @NotEmpty int id, @NotNull @NotEmpty String username, @Email @NotNull @NotEmpty String email, @NotNull @NotEmpty String password, @NotNull @NotEmpty String photo_url, @NotNull @NotEmpty Date last_connexion, @NotNull @NotEmpty String strategy_table, @NotNull @NotEmpty String copy_token, @NotNull @NotEmpty String tx_table, @NotNull @NotEmpty String encrypted_apik) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo_url = photo_url;
        this.last_connexion = last_connexion;
        this.strategy_table = strategy_table;
        this.copy_token = copy_token;
        this.tx_table = tx_table;
        this.encrypted_apik = encrypted_apik;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", last_connexion=" + last_connexion +
                ", strategy_table='" + strategy_table + '\'' +
                ", copy_token='" + copy_token + '\'' +
                ", tx_table='" + tx_table + '\'' +
                ", encrypted_apik='" + encrypted_apik + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Date getLast_connexion() {
        return last_connexion;
    }

    public void setLast_connexion(Date last_connexion) {
        this.last_connexion = last_connexion;
    }

    public String getStrategy_table() {
        return strategy_table;
    }

    public void setStrategy_table(String strategy_table) {
        this.strategy_table = strategy_table;
    }

    public String getCopy_token() {
        return copy_token;
    }

    public void setCopy_token(String copy_token) {
        this.copy_token = copy_token;
    }

    public String getTx_table() {
        return tx_table;
    }

    public void setTx_table(String tx_table) {
        this.tx_table = tx_table;
    }

    public String getEncrypted_apik() {
        return encrypted_apik;
    }

    public void setEncrypted_apik(String encrypted_apik) {
        this.encrypted_apik = encrypted_apik;
    }

    @NotNull
    @NotEmpty
    private String password = ""; //Don't worry, it's hashed and salted ;)

    @NotNull
    @NotEmpty
    private String photo_url = "";

    @NotNull
    @NotEmpty
    private Date last_connexion = new Date();

    @NotNull
    @NotEmpty
    private String strategy_table = "";

    @NotNull
    @NotEmpty
    private String copy_token = "";

    @NotNull
    @NotEmpty
    private String tx_table = "";

    @NotNull
    @NotEmpty
    private String encrypted_apik = "";
}
