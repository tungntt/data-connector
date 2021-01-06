package com.wynnesystems.dc.service.mapper;

import com.wynnesystems.dc.domain.MasterDataEntity;
import com.wynnesystems.dc.service.dto.MasterDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MasterDataMapper extends BaseMapper<MasterDataEntity, MasterDataDTO> {

    @Override
    @Mapping(source = "connectorId", target = "connector.id")
    MasterDataEntity toEntity(final MasterDataDTO dto);

    @Override
    @Mapping(source = "connector.id", target = "connectorId")
    MasterDataDTO toDTO(final MasterDataEntity entity);
}
