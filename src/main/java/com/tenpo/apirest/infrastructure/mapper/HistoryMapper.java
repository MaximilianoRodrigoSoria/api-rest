package com.tenpo.apirest.infrastructure.mapper;


import com.tenpo.apirest.domain.History;
import com.tenpo.apirest.infrastructure.entity.HistoryEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface HistoryMapper {

        @Mappings({
                @Mapping(source = "id", target = "id"),
                @Mapping(source = "endpoint", target = "endpoint"),
                @Mapping(source = "request", target = "request"),
                @Mapping(source = "response", target = "response"),
                @Mapping(source = "timestamp", target = "timestamp"),
                @Mapping(source = "success", target = "success")
               })
        History toModel(HistoryEntity entity);

        @InheritConfiguration
        HistoryEntity toEntity(History model);

        Iterable<History>toModels(Iterable<HistoryEntity> userEntities);
        Iterable<HistoryEntity>toEntities(Iterable<History> model);
}
