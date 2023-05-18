package com.example.healthcaremanagement.security;


import com.example.healthcaremanagement.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Ashot Simonyan on 18.05.23.
 */

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));

        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
