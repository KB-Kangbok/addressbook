package org.kb.addressbook;

import org.springframework.data.jpa.repository.JpaRepository;

interface ContactRepository extends JpaRepository<Contact, String> {
  
}
