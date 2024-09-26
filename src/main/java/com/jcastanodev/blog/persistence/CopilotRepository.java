package com.jcastanodev.blog.persistence;

import com.jcastanodev.blog.domain.Copilot;
import com.jcastanodev.blog.domain.repository.CopilotRepositoryInterface;
import com.jcastanodev.blog.persistence.crud.CopilotCrudRepository;
import com.jcastanodev.blog.persistence.mapper.CopilotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CopilotRepository implements CopilotRepositoryInterface {
    @Autowired
    private CopilotCrudRepository copilotCrudRepository;

    @Autowired
    private CopilotMapper copilotMapper;

    @Override
    public Optional<Copilot> getCopilot(int id) {
        return copilotCrudRepository.findById(id).map(copilotMap -> copilotMapper.toCopilot(copilotMap));
    }
}
