package com.wynnesystems.dc.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"id"})
public class CreateConnectorRequestDTO extends ConnectorDTO{
}
