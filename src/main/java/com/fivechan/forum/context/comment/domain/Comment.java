package com.fivechan.forum.context.comment.domain;
//
import java.util.UUID;

public class Comment {
    private UUID id;
    private UUID userId;
    private UUID topicId;
    private String content;

    public Comment(UUID id, UUID userId, UUID topicId, String content) {
        this.id = id;
        this.userId = userId;
        this.topicId = topicId;
        this.content = content;
    }

    public Comment(UUID userId, UUID topicId, String content) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.topicId = topicId;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Pipeline style methods

    public Comment validate() {
        // Step 1: Validate comment
        if (userId == null || topicId == null || content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid comment data");
        }
        return this;
    }

    public Comment sanitize() {
        // Step 2: Sanitize comment content
        this.content = this.content.replaceAll("<[^>]*>", ""); // Remove HTML tags
        return this;
    }

    public Comment save() {
        // Step 3: Save comment
        // Simulate saving to a database
        System.out.println("Comment saved: " + this);
        return this;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", topicId=" + topicId +
                ", content='" + content + '\'' +
                '}';
    }
}
