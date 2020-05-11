package com.m138.safe;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name="passwortset")
@NamedQuery(name="passwortSet.getAllByUser",query="select p from PasswortSet where p.useridfk = ?1")
public class PasswortSet {

    @Id
    @Column(name="passwortsetid")
    private int passwortSetId;

    @Column(name="website")
    private String website;
    @Column(name="passwort")
    private String passwort;
    @Column(name="useridfk")
    private int userIdFk;

    public int getPasswortSetId() {
        return passwortSetId;
    }

    public void setPasswortSetId(int passwortSetId) {
        this.passwortSetId = passwortSetId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public int getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(int userIdFk) {
        this.userIdFk = userIdFk;
    }
}
