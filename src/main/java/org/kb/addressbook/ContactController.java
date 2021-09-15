package org.kb.addressbook;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class ContactController {

  private final ContactRepository repository;

  ContactController(ContactRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/api/contacts")
  List<Contact> all() {
    return repository.findAll();
  }

  @PostMapping("/api/contacts")
  ResponseEntity<?> newContact(@RequestBody Contact newContact) {
    return ResponseEntity.created(null).body(repository.save(newContact));
  }

  @DeleteMapping("/api/contacts")
  List<Contact> deleteAll() {
    List<Contact> contacts = all();
    repository.deleteAll();
    return contacts;
  }

  @GetMapping("/api/contacts/{contactId}")
  Contact one(@PathVariable String contactId) {
    return repository.findById(contactId).orElseThrow(() -> new ContactNotFoundException(contactId));
  }

  @PutMapping("/api/contacts/{contactId}")
  ResponseEntity<?> replaceContact(@RequestBody Contact newContact, @PathVariable String contactId) {
    return ResponseEntity.ok(
      
      repository.findById(contactId)
        .map(contact -> {
          contact.setFirstname(newContact.getFirstname());
          contact.setFamilyname(newContact.getFamilyname());
          contact.setPhonenumber(newContact.getPhonenumber());
          contact.setEmail(newContact.getEmail());
          return repository.save(contact);
        }).orElseGet(() -> {
          newContact.setId(String.valueOf(contactId));
          return repository.save(newContact);
        })
    );
  }

  @DeleteMapping("/api/contacts/{contactId}")
  Contact deleteContact(@PathVariable String contactId) {
    Contact contact = one(contactId);
    repository.deleteById(contactId);
    return contact;
  }

}
