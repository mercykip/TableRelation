package com.tables.Tables.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tables.Tables.api.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class ModelUsers {
    private Long id;
   @JsonProperty(value = "day")
    private String day;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "roles")
    private List<Role> roles;
   // private String roles;

}
