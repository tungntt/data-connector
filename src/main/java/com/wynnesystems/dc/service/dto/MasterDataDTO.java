package com.wynnesystems.dc.service.dto;

import lombok.Data;

@Data
public class MasterDataDTO {

    private Long id;

    private Long connectorId;

    private String queriedTable;
}
