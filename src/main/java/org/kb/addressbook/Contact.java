package org.kb.addressbook;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
class Contact {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "string_id")
  @GenericGenerator(name = "string_id", strategy = "org.kb.addressbook.StringIdGenerator")
  private String id;
  private String firstname;
  private String familyname;
  private String phonenumber;
  private String email;

  Contact() {}

  Contact(String firstname, String familyname, String phonenumber, String email) {
    this.firstname = firstname;
    this.familyname = familyname;
    this.phonenumber = phonenumber;
    this.email = email;
  }

  public String getId() {
    return this.id;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public String getFamilyname() {
    return this.familyname;
  }

  public String getPhonenumber() {
    return this.phonenumber;
  }

  public String getEmail() {
    return this.email;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setFamilyname(String familyname) {
    this.familyname = familyname;
  }
  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {

    if(this == o) return true;
    if(!(o instanceof Contact)) return false;

    Contact contact = (Contact) o;
    return Objects.equals(this.id, contact.id) && Objects.equals(this.firstname, contact.firstname) && Objects.equals(this.familyname, contact.familyname) && Objects.equals(this.phonenumber, contact.phonenumber) && Objects.equals(this.email, contact.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstname, this.familyname, this.phonenumber, this.email);
  }

  @Override
  public String toString(){
    return "Contact{" + "id='" + this.id + '\'' + ", firstname='" + this.firstname + '\'' + ", familyname='" + this.familyname + '\'' + ", phonenumber='" + this.phonenumber + '\'' + ", email='" + this.email + '\'' + '}';
  }
}
