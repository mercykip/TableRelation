package com.tables.Tables.api.repository;

import com.tables.Tables.api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
