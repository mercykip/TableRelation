package com.tables.Tables.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tables.Tables.api.domain.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name="users")
public class Users {

        @Id
        @GeneratedValue(strategy = AUTO)
        private Long id;

        @LazyCollection(LazyCollectionOption.FALSE)
        @ManyToOne()
        private Days dayName;

        @LazyCollection(LazyCollectionOption.FALSE)
        @ManyToOne()
        private Status statusName;


//       @LazyCollection(LazyCollectionOption.FALSE)
//       @ManyToMany()
//       private Collection<Role> roleName;

    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL )
    private Set<Role> roles;



    private String name;

//    public Users(Days dayName, Status statusName, String name) {
//        this.dayName = dayName;
//        this.statusName = statusName;
//        this.name = name;
//    }


    public Users(Days dayName, Status statusName, String name) {
        this.dayName = dayName;
        this.statusName = statusName;
        this.name = name;
    }
    public void addRole(Role role) {
        this.roles.add(role);
    }
    public Users() {
    }


}
