package tests;

import org.testng.annotations.Test;

public class DeleteNewAddressBookEntryTests extends TestBase {

  @Test
  public void testEditContacts() {
    app.goTo().goToHomePage();
    app.getAddressBookHelper().selectChechBox();
    app.getAddressBookHelper().pressDelete();
  }
}
