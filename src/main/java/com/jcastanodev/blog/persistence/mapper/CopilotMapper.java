package com.jcastanodev.blog.persistence.mapper;

import com.jcastanodev.blog.domain.Copilot;
import com.jcastanodev.blog.persistence.entity.CopilotEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CopilotMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "url", target = "url")
    })
    Copilot toCopilot(CopilotEntity copilotEntity);

    @InheritInverseConfiguration
    CopilotEntity toCopilotEntity(Copilot copilot);
}
