package io.github.espeditomelo.scheduleapi;

import io.github.espeditomelo.scheduleapi.model.entity.Contact;
import io.github.espeditomelo.scheduleapi.model.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScheduleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApiApplication.class, args);
    }
}
