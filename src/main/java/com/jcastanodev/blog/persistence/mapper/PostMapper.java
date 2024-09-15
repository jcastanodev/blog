package com.jcastanodev.blog.persistence.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.jcastanodev.blog.domain.Category;
import com.jcastanodev.blog.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jcastanodev.blog.domain.Post;
import com.jcastanodev.blog.persistence.entity.PostEntity;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface PostMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "content", target = "content"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "userId", target = "userId"),
            // @Mapping(source = "categories", target = "categories"),
            @Mapping(target = "categories", ignore = true),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt")
    })
    Post toPost(PostEntity postEntity);

    default Set<String> mapCategories(Set<CategoryEntity> categoryEntities) {
        return Optional.ofNullable(categoryEntities)
                .orElse(Collections.emptySet())
                .stream()
                .map(CategoryEntity::getName)
                .collect(Collectors.toSet());
    }

    List<Post> toPosts(List<PostEntity> postEntity);

    @InheritInverseConfiguration
    // @Mapping(target = "comments", ignore = true)
    PostEntity toPostEntity(Post post);
}
