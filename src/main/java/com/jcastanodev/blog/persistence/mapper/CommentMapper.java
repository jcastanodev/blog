package com.jcastanodev.blog.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jcastanodev.blog.domain.Comment;
import com.jcastanodev.blog.persistence.entity.CommentEntity;

@Mapper(componentModel = "spring", uses = { PostMapper.class })
public interface CommentMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "post", target = "post"),
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "content", target = "content"),
            @Mapping(source = "createdAt", target = "createdAt")
    })
    Comment toComment(CommentEntity commentEntity);

    @InheritInverseConfiguration
    CommentEntity toCommentEntity(Comment comment);
}
