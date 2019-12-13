package tests;

import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import model.NewAddressBookData;

public class AddNewAddressBookEntryTest {
  private WebDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testAddNewAddressBookEntry() throws Exception {
    goToAddNewBookPage();
    fillAddNewAddressBookForm(getNewAddressBookData());
    submitForm();
    logout();
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

  private void fillAddNewAddressBookForm(NewAddressBookData newAddressBookData) {
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

  private void submitForm() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillTitleField(String title) {
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(title);
  }

  private void fillHomeField(String home) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(home);
  }

  private void fillEmailField(String email) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(email);
  }

  private void fillFaxField(String fax) {
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(fax);
  }

  private void fillWorkField(String fax) {
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(fax);
  }

  private void fillMobileField(String mobile) {
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(mobile);
  }

  private void fillAddressField(String address) {
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(address);
  }

  private void fillCompanyField(String company) {
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(company);
  }

  private void fillNicknameField(String nickname) {
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(nickname);
  }

  private void fillLastNameField(String lastName) {
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(lastName);
  }

  private void fillMiddNameField(String middleName) {
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(middleName);
  }

  private void fillFirstNameField(String firstName) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(firstName);
  }

  private void goToAddNewBookPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    wd.quit();
  }


}
