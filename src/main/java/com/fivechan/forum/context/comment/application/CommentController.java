package com.fivechan.forum.context.comment.application;

import com.fivechan.forum.context.comment.domain.Comment;
import com.fivechan.forum.context.comment.domain.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
        initialize();
    }

    public void initialize() {
        loadConfigurations();
        initializeComponents();
        startServices();
    }

    private void loadConfigurations() {
        // Implementation for loading configurations
    }

    private void initializeComponents() {
        // Implementation for initializing components
    }

    private void startServices() {
        // Implementation for starting services
    }

    @PostMapping
    public void createComment(@RequestBody CommentDTO commentDTO) {
        commentService.createComment(commentDTO);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable UUID id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable UUID id, @RequestBody CommentDTO commentDTO) {
        commentService.updateComment(id, commentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable UUID id) {
        commentService.deleteComment(id);
    }
}
