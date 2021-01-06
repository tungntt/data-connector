package com.wynnesystems.dc.web.rest;

import com.wynnesystems.dc.service.ManagementService;
import com.wynnesystems.dc.service.dto.ConnectorDTO;
import com.wynnesystems.dc.service.dto.CreateConnectorRequestDTO;
import com.wynnesystems.dc.service.dto.CreateMasterDataRequestDTO;
import com.wynnesystems.dc.service.dto.MasterDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/management")
@Slf4j
public class ManagementResource {

    private ManagementService service;

    public ManagementResource(final ManagementService service) {
        this.service = service;
    }

    @PostMapping("/connector")
    @ResponseStatus(HttpStatus.CREATED)
    public ConnectorDTO createConnector(@RequestBody CreateConnectorRequestDTO requestDTO) {
        log.debug("Enter to management resource. Create connector");
        return this.service.createConnector(requestDTO);
    }

    @PostMapping("/master-data")
    @ResponseStatus(HttpStatus.CREATED)
    public MasterDataDTO createMasterData(@RequestBody CreateMasterDataRequestDTO requestDTO) {
        log.debug("Enter to management resource. Create master data");
        return this.service.createMasterData(requestDTO);
    }
}
