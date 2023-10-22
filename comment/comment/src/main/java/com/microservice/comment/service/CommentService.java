package com.microservice.comment.service;

import com.microservice.comment.entity.Comment;
import com.microservice.comment.payload.Post;
import com.microservice.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RestTemplate restTemplate; // Autowired RestTemplate bean


    public Comment saveComment(Comment comment) {
        // Use restTemplate for making HTTP requests
        Post post = restTemplate.getForObject("http://POST-SERVICE/api/posts/" + comment.getPostId(), Post.class);

        if (post != null) {
            String commentId = UUID.randomUUID().toString();
            comment.setCommentId(commentId);
            // Your existing logic
            Comment savedComment = commentRepository.save(comment);
            return savedComment;
        } else {
            return null;
        }
    }

    public List<Comment> getALLCommentsByPostId(String postId) {//and now how i get all the comment for all the method
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;

    }
}

