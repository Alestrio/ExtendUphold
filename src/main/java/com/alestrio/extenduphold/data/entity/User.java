package com.alestrio.extenduphold.data.entity;

import com.alestrio.extenduphold.data.AbstractEntity;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

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
        this.setId(id);
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

    public User(@NotNull @NotEmpty String username, @Email @NotNull @NotEmpty String email, @NotNull @NotEmpty String password, @NotNull @NotEmpty String photo_url, @NotNull @NotEmpty String encrypted_apik) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo_url = photo_url;
        this.strategy_table = this.generateStratID();
        this.copy_token = this.generateCopyToken();
        this.tx_table = this.generateTxID();
        this.encrypted_apik = encrypted_apik;
        this.encryptApik();
        this.hashPassword();
    }

    private String generateTxID() {
        return UUID.randomUUID().toString();
    }

    private String generateCopyToken() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 7);
    }

    private String generateStratID() {
        return UUID.randomUUID().toString();
    }

    /* Those are encryption functions for the API key
    ------------------------------------------------
     */
    private void encryptApik() {
        try{
            SecretKey key = getKeyFromPassword(this.password);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, generateIv());
            byte[] cipherText = cipher.doFinal(this.encrypted_apik.getBytes());
            this.encrypted_apik =  Base64.getEncoder()
                    .encodeToString(cipherText);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String decryptApik(String password) {
        try{
            SecretKey key = getKeyFromPassword(password);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, generateIv());
            byte[] plainText = cipher.doFinal(Base64.getDecoder()
                    .decode(this.encrypted_apik));
            return new String(plainText);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static SecretKey getKeyFromPassword(String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] salt = getNextSalt();

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
                .getEncoded(), "AES");
        return secret;
    }

    private static byte[] getNextSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
    }

    /* --------------------------------------*/

    private void hashPassword() {
        /**
         * This is the function generating the hash from the plain-text password.
         *
         * We will surely have to edit that method in order to use SpringSecurity embeded methods for hash and salt.
         * This way, it would simplify the link between the frontend and the backend : here.
         */
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(getNextSalt());
            this.password = Arrays.toString(md.digest(this.password.getBytes(StandardCharsets.UTF_8)));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public User() { }

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
