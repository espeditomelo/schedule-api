package io.github.espeditomelo.scheduleapi.api.rest;

import io.github.espeditomelo.scheduleapi.model.entity.Contact;
import io.github.espeditomelo.scheduleapi.model.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contacts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContactController {

    // final is required to be a constant
    private final ContactRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact save(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @GetMapping
    public List<Contact> list() {
        return repository.findAll();
    }

    @PatchMapping("{id}/favorite")
    public void favorite(@PathVariable Integer id, @RequestBody Boolean favorite){
        Optional<Contact> contact = repository.findById(id);
        contact.ifPresent( c -> {
            c.setFavorite(favorite);
            repository.save(c);
        });
    }

}
