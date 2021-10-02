package com.tables.Tables.global_services;

import com.tables.Tables.api.domain.Role;
import com.tables.Tables.api.domain.Status;
import com.tables.Tables.api.repository.DayRepository;
import com.tables.Tables.api.repository.RoleRepository;
import com.tables.Tables.api.repository.StatusRepository;
import com.tables.Tables.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalService {
    public static DayRepository dayRepository;
    public static UsersRepository usersRepository;
    public static StatusRepository statusRepository;
    public static RoleRepository roleRepository;

    @Autowired
    public  void setRoleRepository(RoleRepository roleRepository) {
        GlobalService.roleRepository = roleRepository;
    }

    @Autowired
    public  void setDayRepository(DayRepository dayRepository) {

        GlobalService.dayRepository = dayRepository;
    }

    @Autowired
    public  void setUsersRepository(UsersRepository usersRepository) {
        GlobalService.usersRepository = usersRepository;
    }
    @Autowired
    public  void setStatusRepository(StatusRepository statusRepository) {
        GlobalService.statusRepository = statusRepository;
    }
}
