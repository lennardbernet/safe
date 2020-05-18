package com.m138.safe;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.transaction.Transactional;

@Service
public class PasswordService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean login(String password) {

        String hash = null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();

        for (byte d : digest) {
            String nextByte = Integer.toHexString(d & 0xFF).toUpperCase();
            if (nextByte.length() < 2) {
                nextByte = "0" + nextByte;
            }
            hash += nextByte;
        }

        System.out.println(em.getClass());
        Password pw = em.find(Password.class, 1);

        if (pw.getPassword().equals(hash)) {
            return true;
        } else {
            return false;
        }
    }

    public void encrypt(Password password) {
        byte[] key = "123456789".getBytes();
        byte[] dataToSend = password.getPassword().getBytes();
        try {
            Cipher c = Cipher.getInstance("AES");
            SecretKeySpec k =
                    new SecretKeySpec(key, "AES");
            c.init(Cipher.ENCRYPT_MODE, k);
            byte[] encryptedData = c.doFinal(dataToSend);
            password.setPassword(encryptedData.toString());
            em.persist(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Password> decrypt() {
        byte[] key = "123456789".getBytes();
        ArrayList<Password> passwords = (ArrayList<Password>) em.createQuery("select p from Password order by p.passwordid").getResultList();
        passwords.remove(0);
        for (Password p : passwords) {
            try {
                byte[] encryptedData = p.getPassword().getBytes();
                Cipher c = Cipher.getInstance("AES");
                SecretKeySpec k =
                        new SecretKeySpec(key, "AES");
                c.init(Cipher.DECRYPT_MODE, k);
                byte[] data = c.doFinal(encryptedData);
                p.setPassword(data.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return passwords;
    }
}
