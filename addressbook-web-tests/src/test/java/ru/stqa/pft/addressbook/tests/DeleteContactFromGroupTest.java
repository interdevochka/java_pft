package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

public class DeleteContactFromGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().goToHomePage();
      app.contact().createContact(new ContactData("test1", null, "test1"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testDeleteContactFromGroup() {
    ContactData contact = selectContact();
    GroupData group = contact.getGroups().iterator().next();
    app.goTo().goToHomePage();
    app.contact().deleteContactFromGroup(contact, group);
    ContactData modifiedContact = app.db().contacts().stream().filter(contactData -> contactData.getId() == contact.getId()).findAny().get();
    Assert.assertFalse(modifiedContact.getGroups().contains(group));
  }

  private ContactData selectContact() {
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.stream().filter(contactData -> contactData.getGroups().size() != 0).findFirst().orElse(null);
    if (contact == null) {
      contact = contacts.iterator().next();
      app.goTo().goToHomePage();
      app.contact().addContactToGroup(contact, app.db().groups().iterator().next());
      contact = app.db().contacts().stream().filter(contactData -> contactData.getGroups().size() != 0).findFirst().orElse(null);
    }
    return contact;
  }

}
