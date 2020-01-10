package model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

public class ContactData {


  @Expose
  private String firstname;
  @Expose
  private String lastname;
  @Expose
  private String group;
  private String homePhone;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String address;
  @XStreamOmitField
  private int id;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData(String firstname, String secondname, String group) {
    this.firstname = firstname;
    this.lastname = secondname;

    this.group = group;
  }

  public ContactData() {

  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }



  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && firstname.equals(that.firstname) &&
            lastname.equals(that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  public String getFirstname() {
    return firstname;
  }

  public String getSecondName() {
    return lastname;
  }


  public String getGroup() {
    return group;
  }

  public ContactData withFirstName(String firstName) {
    this.firstname = firstName;
    return this;

  }

  public ContactData withLastName(String secondName) {
    this.lastname = secondName;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withHomePhone(String homephone) {
    this.homePhone = homephone;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email) {
    this.email2 = email;
    return this;
  }


  public ContactData withEmail3(String email) {
    this.email3 = email;
    return this;
  }

  public ContactData withAllEmails(String email) {
    this.allEmails = email;
    return this;
  }


  public int getId() {
    return this.id;
  }


  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workphone) {
    this.workPhone = workphone;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }



  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }


  public String getAddress() {
    return address;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
}

