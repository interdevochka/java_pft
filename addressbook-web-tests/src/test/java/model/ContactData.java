package model;

import java.util.Objects;

public class ContactData {

  private final String firstname;
  private final String secondname;
  private String group;

  public ContactData(String firstname, String secondname, String group) {
    this.firstname = firstname;
    this.secondname = secondname;

    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return firstname.equals(that.firstname) &&
            secondname.equals(that.secondname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, secondname);
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return secondname;
  }


  public String getGroup() {
    return group;
  }
}
