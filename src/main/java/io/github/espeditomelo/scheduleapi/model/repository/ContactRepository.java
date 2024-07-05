package io.github.espeditomelo.scheduleapi.model.repository;

import io.github.espeditomelo.scheduleapi.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
