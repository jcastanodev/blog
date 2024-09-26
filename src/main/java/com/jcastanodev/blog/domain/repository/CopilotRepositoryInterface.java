package com.jcastanodev.blog.domain.repository;

import com.jcastanodev.blog.domain.Copilot;

import java.util.Optional;

public interface CopilotRepositoryInterface {
    Optional<Copilot> getCopilot(int copilotId);
}
