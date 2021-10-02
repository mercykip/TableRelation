package com.tables.Tables.api.repository;

import com.tables.Tables.api.domain.Days;
import com.tables.Tables.api.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long > {
    Status findByStatusName(String statusName);
}
