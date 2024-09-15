package com.jcastanodev.blog.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jcastanodev.blog.domain.Post;

public interface PostRepositoryInterface {
    List<Post> getAll();

    Optional<Post> getPost(int postId);

    Optional<List<Post>> getByCategoryId(int categoryId);

    Optional<List<Post>> getByUserId(int userId);

    Post save(Post post);

    void delete(int postId);
}
