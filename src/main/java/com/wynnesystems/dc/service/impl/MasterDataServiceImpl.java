package com.wynnesystems.dc.service.impl;

import com.wynnesystems.dc.domain.MasterDataEntity;
import com.wynnesystems.dc.repository.MasterDataRepository;
import com.wynnesystems.dc.repository.QueryExecutorRepository;
import com.wynnesystems.dc.service.MasterDataService;
import com.wynnesystems.dc.service.dto.ConnectorDTO;
import com.wynnesystems.dc.service.dto.MasterDataDTO;
import com.wynnesystems.dc.service.dto.QueryExecutorDTO;
import com.wynnesystems.dc.service.mapper.ConnectorMapper;
import com.wynnesystems.dc.service.mapper.MasterDataMapper;
import com.wynnesystems.dc.service.mapper.QueryExecutorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MasterDataServiceImpl implements MasterDataService {

    private final QueryExecutorRepository queryExecutorRepository;

    private final MasterDataRepository masterDataRepository;

    private final QueryExecutorMapper queryExecutorMapper;

    public MasterDataServiceImpl(final QueryExecutorRepository queryExecutorRepository, final MasterDataRepository masterDataRepository,
                                 final QueryExecutorMapper queryExecutorMapper) {
        this.queryExecutorRepository = queryExecutorRepository;
        this.masterDataRepository = masterDataRepository;
        this.queryExecutorMapper = queryExecutorMapper;
    }

    @Override
    public List<Map<String, Object>> executeMasterDataById(final long id) {
        final MasterDataEntity masterDataEntity = this.masterDataRepository.findById(id)
                .orElseThrow((() -> new IllegalArgumentException(String.format("Not found master data by %s", id))));
        final QueryExecutorDTO queryExecutorDTO = this.queryExecutorMapper.toDTO(masterDataEntity);
        return this.queryExecutorRepository.getAll(queryExecutorDTO, 10);
    }
}
