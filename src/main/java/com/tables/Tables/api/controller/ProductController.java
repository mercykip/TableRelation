package com.tables.Tables.api.controller;


import com.tables.Tables.api.domain.Days;
import com.tables.Tables.api.domain.Role;
import com.tables.Tables.api.domain.Status;
import com.tables.Tables.api.domain.Users;
import com.tables.Tables.api.domain.enums.UserType;
import com.tables.Tables.api.models.ModelUsers;
import com.tables.Tables.api.repository.DayRepository;
import com.tables.Tables.api.repository.UsersRepository;
import org.apache.catalina.User;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.tables.Tables.global_services.GlobalService.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {


    @ApiIgnore
    @PostMapping("/addDays")
    public ResponseEntity addDays(@RequestBody ModelUsers modelUsers, Users user) {
        Role role = roleRepository.findByRoleName("User");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        Status status= statusRepository.findByStatusName(modelUsers.getStatus());
        if(status == null){
            return new ResponseEntity<>("status not found", HttpStatus.NOT_FOUND);
        }

        Days day= dayRepository.findByDayName(modelUsers.getDay());
        if(day == null){
            return new ResponseEntity<>("Day not found", HttpStatus.NOT_FOUND);
        }
        try {
            Users users =new Users(day,status,modelUsers.getName());
            users.setRoles(roleSet);
            Users savedUser = usersRepository.save(users);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
           // return new ResponseEntity<>("savedUser", HttpStatus.OK);
        } catch (HttpMessageNotReadableException e) {
            return new ResponseEntity<>("Invalid", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occured while saving", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiIgnore
    @GetMapping("/getDays")
    public ResponseEntity getDays(){
        List<Days> days= dayRepository.findAll();
        return new ResponseEntity<>(days, HttpStatus.OK);
    }

    @ApiIgnore
    @GetMapping("/getStatus")
    public ResponseEntity getStatus(){
        List<Status> statuses= statusRepository.findAll();
        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }


}
