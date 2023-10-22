package com.microservice.post.controller;

import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;//after postservice and service use repository access
    @PostMapping
    public ResponseEntity<Post>savePost(@RequestBody Post post){//FIRST METHOD IS TO SAVE
        Post newPost = postService.savePost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
    //http://localhost:8081/api/posts{postId}
     @GetMapping("/{postId}")//whatever variable name giving it shold match second line one
    public Post getPostByPostId(@PathVariable String postId) {//job of this find a post based on the post id
      Post post = postService.findPostById(postId);
      return post;//this will response entity and http.ok this will automatically give status code 200
    }
    //http://localhost:8081/api/posts{postId}/comments
    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostDto> getPostWithComments(@PathVariable String postId){
        PostDto postDto = postService.getPostWithComments(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }
}
