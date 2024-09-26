package com.jcastanodev.blog.persistence.crud;

import com.jcastanodev.blog.persistence.entity.CopilotEntity;
import org.springframework.data.repository.CrudRepository;

public interface CopilotCrudRepository extends CrudRepository<CopilotEntity, Integer> {}
