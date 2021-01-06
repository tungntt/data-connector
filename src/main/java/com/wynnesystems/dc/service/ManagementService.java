package com.wynnesystems.dc.service;

import com.wynnesystems.dc.service.dto.ConnectorDTO;
import com.wynnesystems.dc.service.dto.CreateConnectorRequestDTO;
import com.wynnesystems.dc.service.dto.CreateMasterDataRequestDTO;
import com.wynnesystems.dc.service.dto.MasterDataDTO;

public interface ManagementService {

    ConnectorDTO createConnector(final CreateConnectorRequestDTO requestDto);

    MasterDataDTO createMasterData(final CreateMasterDataRequestDTO requestDto);
}
