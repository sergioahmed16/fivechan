package com.fivechan.forum.context.user.domain;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String description;
    private String avatar;
    private String email;

    public User(UUID id, String name, String description, String avatar, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public  void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
