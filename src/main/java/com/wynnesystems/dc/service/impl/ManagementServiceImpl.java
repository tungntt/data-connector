package com.wynnesystems.dc.service.impl;

import com.wynnesystems.dc.domain.ConnectorEntity;
import com.wynnesystems.dc.domain.MasterDataEntity;
import com.wynnesystems.dc.repository.ConnectorRepository;
import com.wynnesystems.dc.repository.MasterDataRepository;
import com.wynnesystems.dc.service.ManagementService;
import com.wynnesystems.dc.service.dto.ConnectorDTO;
import com.wynnesystems.dc.service.dto.CreateConnectorRequestDTO;
import com.wynnesystems.dc.service.dto.CreateMasterDataRequestDTO;
import com.wynnesystems.dc.service.dto.MasterDataDTO;
import com.wynnesystems.dc.service.mapper.ConnectorMapper;
import com.wynnesystems.dc.service.mapper.MasterDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManagementServiceImpl implements ManagementService {

    private ConnectorRepository connectorRepository;

    private MasterDataRepository masterDataRepository;

    private ConnectorMapper connectorMapper;

    private MasterDataMapper masterDataMapper;

    public ManagementServiceImpl(ConnectorRepository connectorRepository, MasterDataRepository masterDataRepository,
                                 ConnectorMapper connectorMapper, MasterDataMapper masterDataMapper) {
        this.connectorRepository = connectorRepository;
        this.masterDataRepository = masterDataRepository;
        this.connectorMapper = connectorMapper;
        this.masterDataMapper = masterDataMapper;
    }

    @Override
    public ConnectorDTO createConnector(final CreateConnectorRequestDTO requestDto) {
        log.debug("Create Connector of db type {}", requestDto.getDbType());
        ConnectorEntity connectorEntity = this.connectorMapper.toEntity(requestDto);
        connectorEntity = this.connectorRepository.save(connectorEntity);
        return this.connectorMapper.toDTO(connectorEntity);
    }

    @Override
    public MasterDataDTO createMasterData(final CreateMasterDataRequestDTO requestDto) {
        log.debug("Create Master Data Connecting To Connector {}", requestDto.getConnectorId());
        MasterDataEntity masterDataEntity = this.masterDataMapper.toEntity(requestDto);
        masterDataEntity = this.masterDataRepository.save(masterDataEntity);
        return this.masterDataMapper.toDTO(masterDataEntity);
    }
}
