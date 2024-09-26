package com.jcastanodev.blog.domain.service;

import com.jcastanodev.blog.domain.repository.CopilotRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopilotService {
    @Autowired
    private CopilotRepositoryInterface copilotRepository;

    public String get() {
        return copilotRepository.getCopilot(1).isPresent() ? copilotRepository.getCopilot(1).get().getUrl() : "";
    }
}
