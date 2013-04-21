package com.gao.core.framework.repository.properties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;

/**
 * This will hold Jackrabbit related properties
 * 
 * @author goutham_PN
 */
@Entity
public class JackRabbitRepositoryProperties implements Serializable {

    @Id
    private String repository_id;
    @Column(name = "nfs_path", nullable = false)
    private String nfs_path;
    @Column(name = "database_driver_name", nullable = false)
    private String database_driver_name;
    @Column(name = "database_driver_url", nullable = false)
    private String database_driver_url;
    @Column(name = "database_username", nullable = false)
    private String database_username;
    @Column(name = "database_password", nullable = false)
    private String database_password;
    @Column(name = "database_schema_type", nullable = false)
    private String database_schema_type;

    public String getDatabase_driver_name() {
        return database_driver_name;
    }

    public void setDatabase_driver_name(String database_driver_name) {
        this.database_driver_name = database_driver_name;
    }

    public String getDatabase_driver_url() {
        return database_driver_url;
    }

    public void setDatabase_driver_url(String database_driver_url) {
        this.database_driver_url = database_driver_url;
    }

    public String getDatabase_password() {
        return database_password;
    }

    public void setDatabase_password(String database_password) {
        this.database_password = database_password;
    }

    public String getDatabase_schema_type() {
        return database_schema_type;
    }

    public void setDatabase_schema_type(String database_schema_type) {
        this.database_schema_type = database_schema_type;
    }

    public String getDatabase_username() {
        return database_username;
    }

    public String getNfs_path() {
        return nfs_path;
    }

    public void setNfs_path(String nfs_path) {
        this.nfs_path = nfs_path;
    }

    public void setDatabase_username(String database_username) {
        this.database_username = database_username;
    }

    public String getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(String repository_id) {
        this.repository_id = repository_id;
    }
}
