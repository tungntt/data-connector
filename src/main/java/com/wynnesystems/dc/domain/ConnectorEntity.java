package com.wynnesystems.dc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "connector")
@Data
public class ConnectorEntity implements Serializable {

    public enum DbType {
        DB2, MYSQL;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "db_type")
    @Enumerated(EnumType.STRING)
    private DbType dbType;

    @Column(name = "host")
    private String host;

    @Column(name = "port")
    private Integer port;

    @Column(name = "dbName")
    private String dbName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
