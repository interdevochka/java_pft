package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactData {

  @Id
  @Column(name = "id")
  private int id;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;


  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Column(columnDefinition = "TEXT")
  private String email;
  @Column(columnDefinition = "TEXT")
  private String email2;
  @Column(columnDefinition = "TEXT")
  private String email3;
  @Transient
  private String allEmails;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Transient
  private String allPhones;

  @Column(columnDefinition = "TEXT")
  private String address;

  public Groups getGroups() {
    return new Groups(groups);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @XStreamOmitField

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();


  public File getPhoto() {
    if (photo == null) {
      return null;
    }
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData(String firstname, String secondname, String group) {
    this.firstname = firstname;
    this.lastname = secondname;
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


  public ContactData withFirstName(String firstName) {
    this.firstname = firstName;
    return this;

  }

  public ContactData withLastName(String secondName) {
    this.lastname = secondName;
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


  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}

