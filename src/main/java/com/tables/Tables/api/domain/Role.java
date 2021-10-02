package com.tables.Tables.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;
//https://dzone.com/articles/introduction-to-spring-data-jpa-part-8-many-to-man
@Getter
@Setter
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String roleName;
//    @ManyToMany(targetEntity = Users.class, mappedBy = "roles", cascade = CascadeType.ALL)
//    private List<Users> users;

    @Override
    public String toString() {
        return this.roleName;
    }

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
