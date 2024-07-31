package com.fivechan.forum.context.comment.application;

import com.fivechan.forum.context.comment.domain.Comment;
import com.fivechan.forum.context.comment.domain.CommentDTO;
import com.fivechan.forum.context.comment.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(CommentDTO commentDTO) {
        Comment comment = new Comment(commentDTO.getUserId(), commentDTO.getTopicId(), commentDTO.getContent());
        commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(UUID id) {
        return commentRepository.findById(id);
    }

    public void updateComment(UUID id, CommentDTO commentDTO) {
        Comment comment = new Comment(id, commentDTO.getUserId(), commentDTO.getTopicId(), commentDTO.getContent());
        commentRepository.update(comment);
    }

    public void deleteComment(UUID id) {
        Comment comment = commentRepository.findById(id);
        commentRepository.delete(comment);
    }
}
