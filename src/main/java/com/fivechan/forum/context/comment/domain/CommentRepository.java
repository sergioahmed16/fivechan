package com.fivechan.forum.context.comment.domain;

import java.util.List;
import java.util.UUID;

public interface CommentRepository {
    void save(Comment comment);
    List<Comment> findAll();
    Comment findById(UUID id);
    void update(Comment comment);
    void delete(Comment comment);
    List<Comment> findByTopicId(UUID topicId);
}
