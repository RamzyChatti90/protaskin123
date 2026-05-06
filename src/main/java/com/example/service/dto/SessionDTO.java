package com.example.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.domain.Session}.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SessionDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessionDTO)) return false;
        return Objects.equals(id, ((SessionDTO) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SessionDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}