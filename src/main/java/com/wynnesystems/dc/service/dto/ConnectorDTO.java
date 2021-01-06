package com.wynnesystems.dc.service.dto;

import com.wynnesystems.dc.domain.ConnectorEntity;
import lombok.Data;

@Data
public class ConnectorDTO {

    private Long id;

    private ConnectorEntity.DbType dbType;

    private String host;

    private Integer port;

    private String dbName;

    private String username;

    private String password;
}
