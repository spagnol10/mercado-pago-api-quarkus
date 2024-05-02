package org.acme.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserBO {

    private UUID id;
    private Integer codigo;
    private String name;
    private String email;
    private String password;
    private Address address;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserBO(UUID id, Integer codigo, String name, String email, String password, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.codigo = codigo;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
