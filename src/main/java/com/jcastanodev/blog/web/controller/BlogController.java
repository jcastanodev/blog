package com.jcastanodev.blog.web.controller;

import com.jcastanodev.blog.domain.Post;
import com.jcastanodev.blog.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${spring.cors.allowed-origins}")
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
    public ResponseEntity<List<Post>> getByCategoryId(int categoryId) {
        return postService.getByCategoryId(categoryId).map(posts -> new ResponseEntity<>(posts, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getByUserId(int userId) {
        return postService.getByUserId(userId).map(posts -> new ResponseEntity<>(posts, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Post> save(@RequestBody Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{postId}")
    public ResponseEntity<Void> delete(int postId) {
        return postService.delete(postId) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
