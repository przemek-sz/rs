package com.szczerbap.rssreader.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
    //==============================================================//
    @OneToMany(mappedBy = "user")
    private Set<RssChannel> channelSet = new HashSet<>();
    //==============================================================//
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private Set<UserRole> roles = new HashSet<>();

    //=============================================================//
    public Long getId() {
        return id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RssChannel> getChannelSet() {
        return channelSet;
    }

    public void setChannelSet(Set<RssChannel> channelSet) {
        this.channelSet = channelSet;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
