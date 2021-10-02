package com.tables.Tables;

import com.tables.Tables.api.domain.Days;
import com.tables.Tables.api.domain.enums.UserType;
import com.tables.Tables.api.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.tables.Tables.global_services.GlobalService.dayRepository;

public class DataTest {
    @Autowired
    static DayRepository dayRepository;

    public static void main(String[] args) {
        List<Days> days= dayRepository.findAll();
     //   List<Days> daysList = days.stream().collect(Collectors.toList());

        System.out.println(days);
    }
}
