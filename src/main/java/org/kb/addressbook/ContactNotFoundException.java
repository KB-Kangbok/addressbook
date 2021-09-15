package org.kb.addressbook;

class ContactNotFoundException extends RuntimeException {
  
  ContactNotFoundException(String id) {
    super("Could not find employee " + id);
  }
}
