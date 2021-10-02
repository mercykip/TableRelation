package com.tables.Tables;

import com.tables.Tables.api.domain.Days;
import com.tables.Tables.api.domain.Role;
import com.tables.Tables.api.domain.Status;
import com.tables.Tables.api.domain.Users;
import com.tables.Tables.api.domain.enums.UserType;
import com.tables.Tables.api.repository.DayRepository;
import com.tables.Tables.api.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.tables.Tables.global_services.GlobalService.*;

@SpringBootApplication
public class TablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TablesApplication.class, args);
	}

	@Bean
	CommandLineRunner run () {
		return args -> {
//			//day
//			dayRepository.save(new Days("MONDAY"));
//			dayRepository.save(new Days("TUESDAY"));
//			dayRepository.save(new Days("WEDNESDAY"));
//			// status
//			statusRepository.save(new Status("Active"));
//			statusRepository.save(new Status("InActive"));
//			statusRepository.save(new Status("ProActive"));
//            // role
//			roleRepository.save(new Role("Admin"));
//			roleRepository.save(new Role("User"));
//			roleRepository.save(new Role("SuperAdmin"));




		};
}

}
