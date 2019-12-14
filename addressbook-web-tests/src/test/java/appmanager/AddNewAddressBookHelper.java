package appmanager;

import model.NewAddressBookData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewAddressBookHelper extends HelperBase {
  public AddNewAddressBookHelper(WebDriver wd) {
    super(wd);
  }

  public void submitForm() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillAddNewAddressBookForm(NewAddressBookData newAddressBookData) {
    fillFirstNameField(newAddressBookData.getFirstName());
    fillMiddNameField(newAddressBookData.getMiddleName());
    fillLastNameField(newAddressBookData.getLastName());
    fillNicknameField(newAddressBookData.getNickname());
    fillCompanyField(newAddressBookData.getCompany());
    fillAddressField(newAddressBookData.getAddress());
    fillMobileField(newAddressBookData.getMobile());
    fillWorkField(newAddressBookData.getWork());
    fillFaxField(newAddressBookData.getFax());
    fillEmailField(newAddressBookData.getEmail());
    fillHomeField(newAddressBookData.getHome());
    fillTitleField(newAddressBookData.getTitle());
  }

  private void fillTitleField(String title) {
    click(By.name("title"));
    type(By.name("title"), title);
  }

  private void fillHomeField(String home) {
    click(By.name("home"));
    type(By.name("home"), home);
  }

  private void fillEmailField(String email) {
    click(By.name("email"));
    type(By.name("email"), email);
  }

  private void fillFaxField(String fax) {
    click(By.name("fax"));
    type(By.name("fax"), fax);
  }

  private void fillWorkField(String work) {
    click(By.name("work"));
    type(By.name("work"), work);
  }

  private void fillMobileField(String mobile) {
    click(By.name("mobile"));
    type(By.name("mobile"), mobile);
  }

  private void fillAddressField(String address) {
    click(By.name("address"));
    type(By.name("address"), address);
  }

  private void fillCompanyField(String company) {
    click(By.name("company"));
    type(By.name("company"), company);
  }

  private void fillNicknameField(String nickname) {
    click(By.name("nickname"));
    type(By.name("nickname"), nickname);
  }

  private void fillLastNameField(String lastName) {
    click(By.name("lastname"));
    type(By.name("lastname"), lastName);
  }

  private void fillMiddNameField(String middleName) {
    click(By.name("middlename"));
    type(By.name("middlename"), middleName);
  }

  private void fillFirstNameField(String firstName) {
    click(By.name("firstname"));
    type(By.name("firstname"), firstName);
  }
}
