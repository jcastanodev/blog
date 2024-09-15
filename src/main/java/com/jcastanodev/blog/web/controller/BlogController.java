package com.jcastanodev.blog.web.controller;

import com.jcastanodev.blog.domain.Post;
import com.jcastanodev.blog.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable int postId) {
        return postService.getPost(postId).map(post -> new ResponseEntity<>(post, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Post>> getByCategoryId(int categoryId) {
        return postService.getByCategoryId(categoryId);
    }

    @GetMapping("/user/{userId}")
    public Optional<List<Post>> getByUserId(int userId) {
        return postService.getByUserId(userId);
    }

    @PostMapping("/")
    public Post save(@RequestBody Post post) {
        // System.out.println(post.getTitle());
        return postService.save(post);
    }

    @PostMapping("/delete/{postId}")
    public boolean delete(int postId) {
        return postService.delete(postId);
    }
}
