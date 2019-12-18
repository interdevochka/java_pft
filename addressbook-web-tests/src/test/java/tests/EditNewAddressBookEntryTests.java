package tests;

import model.NewAddressBookData;
import org.testng.annotations.Test;

public class EditNewAddressBookEntryTests extends TestBase {
  @Test
  public void testEditContacts() {
    app.getNavigationHelper().goToHomePage();
    app.getAddressBookHelper().goToEditPage();
    app.getAddressBookHelper().fillAddNewAddressBookForm(getNewAddressBookData());
    app.getAddressBookHelper().pressUpdate();


  }
  private NewAddressBookData getNewAddressBookData() {
    NewAddressBookData contact = new NewAddressBookData();
    contact.setFirstName("Victor");
    contact.setMiddleName("Petrovich");
    contact.setLastName("Galkin");
    contact.setNickname("Pop");
    contact.setCompany("Lucoil");
    contact.setAddress("Novosibirsk, Sovetskaya str. 11-14");
    contact.setMobile("+791346677");
    contact.setWork("mywork1");
    contact.setFax("+79134588");
    contact.setEmail("test1@mail.ru");
    contact.setHome("no answer2");
    contact.setTitle("no title2");
    return contact;
  }
}

