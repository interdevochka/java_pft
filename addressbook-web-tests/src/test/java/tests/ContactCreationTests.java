package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", "test1"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }


}
