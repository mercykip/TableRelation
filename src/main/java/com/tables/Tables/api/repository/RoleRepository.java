package com.tables.Tables.api.repository;

import com.tables.Tables.api.domain.Role;
import com.tables.Tables.api.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
