package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
  private ContactData contactData;

  public ContactHelper(WebDriver wd) {super (wd); }

  public void initContactCreation() { click(By.linkText("add new")); }
  public void fillContactForm(ContactData contactData) {
    this.contactData = contactData;
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
  }

  public void submitContactCreation() { click(By.name("submit")); }

  public void returnToHomePage() { click(By.linkText("home page")); }

  public void initContactModification() { click(By.cssSelector("img[alt='Edit']")); }

  public void submitContactModification() {
    click(By.name("update"));
  }

}
