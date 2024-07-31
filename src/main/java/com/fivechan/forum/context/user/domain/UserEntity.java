package com.fivechan.forum.context.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    private String avatar;

    public UserEntity(UUID id, String name, String description, String avatar) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avatar = avatar;
    }

    public User toDomain() {
        return new User(id, name, description, avatar);
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getDescription(), user.getAvatar());
    }
}
