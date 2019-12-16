package tests;

import org.testng.annotations.Test;

public class EditNewAddressBookEntryTests extends TestBase {
  @Test
  public void testEditContacts() {
    app.getNavigationHelper().goToHomePage();
    app.getAddressBookHelper().goToEditPage();
    app.getAddressBookHelper().fillFirstNameField("Petya");
    app.getAddressBookHelper().pressUpdate();

  }
}
