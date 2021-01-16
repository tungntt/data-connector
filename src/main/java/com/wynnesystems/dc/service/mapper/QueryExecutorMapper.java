package com.wynnesystems.dc.service.mapper;

import com.wynnesystems.dc.domain.MasterDataEntity;
import com.wynnesystems.dc.service.dto.QueryExecutorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ConnectorMapper.class, MasterDataMapper.class})
public interface QueryExecutorMapper {

    @Mapping(source = "id", target = "masterData.id")
    @Mapping(source = "queriedTable", target = "masterData.queriedTable")
    QueryExecutorDTO toDTO (final MasterDataEntity entity);

}
