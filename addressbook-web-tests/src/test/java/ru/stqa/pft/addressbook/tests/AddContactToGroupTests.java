package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Iterator;
import java.util.stream.Collectors;

public class AddContactToGroupTests extends TestBase {

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
  public void testAddContactToGroup() {
    ContactData contact = selectContact();
    GroupData group = app.db().groups().stream().filter(groupData -> !contact.getGroups().contains(groupData)).findFirst().get();
    app.goTo().goToHomePage();
    app.contact().addContactToGroup(contact, group);
    Contacts contactsAfter = app.db().contacts();
    ContactData modifiedContact = contactsAfter.stream().filter(contactData -> contactData.getId() == contact.getId()).collect(Collectors.toList()).iterator().next();
    Assert.assertTrue(modifiedContact.getGroups().stream().anyMatch(groupData -> groupData.equals(group)));
  }

  private ContactData selectContact() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    ContactData contact = contacts.iterator().next();
    boolean isContactInAllCroups = contact.getGroups() != null && !contact.getGroups().isEmpty() && contact.getGroups().containsAll(groups);
    Iterator<ContactData> iterator = contacts.iterator();
    while (isContactInAllCroups && iterator.hasNext()) {
      contact = iterator.next();
      isContactInAllCroups = contact.getGroups() != null && !contact.getGroups().isEmpty() && contact.getGroups().containsAll(groups);
    }
    if (isContactInAllCroups) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("fwefw1"));
    }
    return contact;
  }
}
