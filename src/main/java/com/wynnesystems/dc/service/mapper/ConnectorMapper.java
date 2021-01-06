package com.wynnesystems.dc.service.mapper;

import com.wynnesystems.dc.domain.ConnectorEntity;
import com.wynnesystems.dc.service.dto.ConnectorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConnectorMapper extends BaseMapper<ConnectorEntity, ConnectorDTO> {

}
