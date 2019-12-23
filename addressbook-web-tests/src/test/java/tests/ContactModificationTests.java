package tests;

import model.ContactData;
import model.GroupData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{


  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, "test1"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
   }
}
