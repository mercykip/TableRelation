package com.tables.Tables.api.repository;

import com.tables.Tables.api.domain.Days;
import com.tables.Tables.api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Days, Long> {
    Days findByDayName(String dayName);
}
