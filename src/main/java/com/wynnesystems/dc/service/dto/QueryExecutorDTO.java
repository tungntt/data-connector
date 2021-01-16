package com.wynnesystems.dc.service.dto;

import lombok.Data;

@Data
public class QueryExecutorDTO {

    private MasterDataDTO masterData;

    private ConnectorDTO connector;
}
