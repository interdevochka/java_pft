package tests;

import org.jetbrains.annotations.NotNull;
import org.testng.annotations.*;
import model.NewAddressBookData;

public class AddNewAddressBookEntryTests extends TestBase {

  @Test
  public void testAddNewAddressBookEntry() {
    app.goTo().goToAddNewBookPage();
    app.getAddressBookHelper().fillAddNewAddressBookForm(getNewAddressBookData());
    app.getAddressBookHelper().submitForm();
  }

  @NotNull
  private NewAddressBookData getNewAddressBookData() {
    NewAddressBookData object = new NewAddressBookData();
    object.setFirstName("Vasya");
    object.setMiddleName("Ivanovich");
    object.setLastName("Pupkin");
    object.setNickname("Pup");
    object.setCompany("Gazprom");
    object.setAddress("Novosibirsk, Sovetskaya str. 10-12");
    object.setMobile("+791346666");
    object.setWork("mywork");
    object.setFax("+791345555");
    object.setEmail("test@mail.ru");
    object.setHome("no answer");
    object.setTitle("no title");
    return object;
  }

}
