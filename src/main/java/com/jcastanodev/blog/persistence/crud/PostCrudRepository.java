package com.jcastanodev.blog.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jcastanodev.blog.persistence.entity.PostEntity;

public interface PostCrudRepository extends CrudRepository<PostEntity, Integer> {
    List<PostEntity> findByActiveTrue();

    Optional<List<PostEntity>> findByUserIdOrderByCreatedAtDesc(int userId);

    @Query("SELECT p FROM PostEntity p JOIN p.categories c WHERE c.id = :categoryId")
    Optional<List<PostEntity>> findByCategoryId(@Param("categoryId") int categoryId);
}
