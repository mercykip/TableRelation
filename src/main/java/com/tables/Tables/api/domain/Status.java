package com.tables.Tables.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name="status")
public class Status {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    String statusName;

    public Status() {
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }
}
