package com.jcastanodev.blog.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jcastanodev.blog.domain.Post;
import com.jcastanodev.blog.domain.repository.PostRepositoryInterface;
import com.jcastanodev.blog.persistence.crud.PostCrudRepository;
import com.jcastanodev.blog.persistence.entity.PostEntity;
import com.jcastanodev.blog.persistence.mapper.PostMapper;

@Repository
public class PostRepository implements PostRepositoryInterface {
    @Autowired
    private PostCrudRepository postCrudRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> getAll() {
        List<PostEntity> posts = postCrudRepository.findByActiveTrue();
        return postMapper.toPosts(posts);
    }

    @Override
    public Optional<Post> getPost(int postId) {
        return postCrudRepository.findById(postId).map(postMap -> postMapper.toPost(postMap));
    }

    @Override
    public Optional<List<Post>> getByCategoryId(int categoryId) {
        Optional<List<PostEntity>> posts = postCrudRepository.findByCategoryId(categoryId);
        return posts.map(postsMap -> postMapper.toPosts(postsMap));
    }

    @Override
    public Optional<List<Post>> getByUserId(int userId) {
        Optional<List<PostEntity>> posts = postCrudRepository.findByUserIdOrderByCreatedAtDesc(userId);
        return posts.map(postsMap -> postMapper.toPosts(postsMap));
    }

    @Override
    public Post save(Post post) {
        PostEntity postEntity = postMapper.toPostEntity(post);
        return postMapper.toPost(postCrudRepository.save(postEntity));
    }

    @Override
    public void delete(int postId) {
        postCrudRepository.deleteById(postId);
    }
}
