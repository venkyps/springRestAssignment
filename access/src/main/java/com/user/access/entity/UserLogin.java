package com.user.access.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN")
public class UserLogin {

    @Id
    @Column(name = "USERNAME")
    private String  userName;

    @Column(name = "PASSWORD")
    private String  password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
