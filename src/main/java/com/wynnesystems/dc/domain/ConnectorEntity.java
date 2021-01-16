package com.wynnesystems.dc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "connector")
@Data
public class ConnectorEntity implements Serializable {

    public enum DbType {
        DB2("com.ibm.db2.jcc.DB2Driver", "org.hibernate.dialect.MySQLDialect"),
        MYSQL("com.mysql.jdbc.Driver", "org.hibernate.dialect.MySQLDialect");

        private String driverClassName;
        private String hibernateDialect;

        DbType(final String driverClassName, final String hibernateDialect) {
            this.driverClassName = driverClassName;
            this.hibernateDialect = hibernateDialect;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public String getHibernateDialect() {
            return hibernateDialect;
        }

        public void setHibernateDialect(String hibernateDialect) {
            this.hibernateDialect = hibernateDialect;
        }
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
