package io.github.espeditomelo.scheduleapi.api.rest;

import io.github.espeditomelo.scheduleapi.model.entity.Contact;
import io.github.espeditomelo.scheduleapi.model.repository.ContactRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
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
    public void favorite(@PathVariable Integer id){
        Optional<Contact> contact = repository.findById(id);
        contact.ifPresent( c -> {
            boolean favorite = c.getFavorite() == Boolean.TRUE;
            c.setFavorite(!favorite);
            repository.save(c);
        });
    }

    @PutMapping("{id}/photo")
    public byte[] addPhoto(@PathVariable Integer id, @RequestParam("photo")Part file) {
        Optional<Contact> contact = repository.findById(id);
        return contact.map( c -> {
            try {
                InputStream is = file.getInputStream();
                byte[] bytes = new byte[(int) file.getSize()];
                IOUtils.readFully(is, bytes);
                c.setPhoto(bytes);
                this.repository.save(c);
                is.close();
                return bytes;
            } catch (IOException e) {
                return null;
            }
        }).orElse(null);
    }
}
