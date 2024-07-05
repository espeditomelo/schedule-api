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

//    @Bean
//    public CommandLineRunner commandLineRunner(@Autowired ContactRepository repository) {
//        return  args -> {
//            Contact contact = new Contact();
//            contact.setName("James");
//            contact.setEmail("james@email.com");
//            contact.setFavorite(false);
//            repository.save(contact);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApiApplication.class, args);
    }
}
