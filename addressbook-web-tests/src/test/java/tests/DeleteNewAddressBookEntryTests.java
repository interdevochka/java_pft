package tests;

import org.testng.annotations.Test;

public class DeleteNewAddressBookEntryTests extends TestBase {

  @Test
  public void testEditContacts() {
    app.getNavigationHelper().goToHomePage();
    app.getAddressBookHelper().selectChechBox();
    app.getAddressBookHelper().pressDelete();
  }
}
