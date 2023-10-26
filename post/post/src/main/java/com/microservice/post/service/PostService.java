package com.microservice.post.service;
import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Post savePost(Post post){
        //in entity here we just give @Id i didnot use generated value..autogeneration we didnot use in entity
        //here we use UUID.RANDOMUUID()AND CONVERT TO tostring() and save it local string varible
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    public Post findPostById(String postId) {
       // Optional<Post> byId = postRepository.findById(postId);//here it will give optional byt we can use get() and convert
        Post post = postRepository.findById(postId).get();
        return post;
    }

    public PostDto getPostWithComments(String postId) {//resttamplate use
        Post post = postRepository.findById(postId).get();
        ArrayList comments = restTemplate.getForObject("http://COMMENT-SERVICE/api/Comments/" + postId, ArrayList.class);
                                          //without getRestTamplate()
        //get both details entity and dto
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setComments(comments);
        return postDto;

    }
}
