package com.jcastanodev.blog.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcastanodev.blog.domain.Post;
import com.jcastanodev.blog.domain.repository.PostRepositoryInterface;

@Service
public class PostService {
    @Autowired
    private PostRepositoryInterface postRepository;

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public Optional<Post> getPost(int postId) {
        return postRepository.getPost(postId);
    }

    public Optional<List<Post>> getByCategoryId(int categoryId) {
        return postRepository.getByCategoryId(categoryId);
    }

    public Optional<List<Post>> getByUserId(int userId) {
        return postRepository.getByUserId(userId);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public boolean delete(int postId) {
        postRepository.delete(postId);
        return getPost(postId).map(postMap -> {
            postRepository.delete(postId);
            return true;
        }).orElse(false);
    }
}
