package com.szczerbap.rssreader.model;

import javax.persistence.*;

@Entity
public class RssChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public RssChannel(){

    }

    public RssChannel(String url){
        this.url=url;
    }


    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
