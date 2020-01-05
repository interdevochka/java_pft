package model;

import java.util.Objects;

public class ContactData {

  private String firstname;
  private String secondname;
  private String group;
  private int id;

  public ContactData(String firstname, String secondname, String group) {
    this.firstname = firstname;
    this.secondname = secondname;

    this.group = group;
  }

  public ContactData() {

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && firstname.equals(that.firstname) &&
            secondname.equals(that.secondname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, secondname);
  }

  public String getFirstname() {
    return firstname;
  }

  public String getSecondName() {
    return secondname;
  }


  public String getGroup() {
    return group;
  }

  public ContactData withFirstName(String firstName) {
    this.firstname = firstName;
    return this;

  }

  public ContactData withSecondName(String secondName) {
    this.secondname = secondName;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public int getId() {
    return this.id;
  }
}
