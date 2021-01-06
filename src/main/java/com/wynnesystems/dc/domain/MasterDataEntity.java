package com.wynnesystems.dc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master_data")
@Data
public class MasterDataEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "connector_id")
    private ConnectorEntity connector;

    @Column(name = "queried_table")
    private String queriedTable;
}
