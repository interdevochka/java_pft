package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {
  private ContactData contactData;

  public ContactHelper(WebDriver wd) {super (wd); }

  public void initContactCreation() { click(By.linkText("add new")); }
  public void fillContactForm(ContactData contactData, boolean creation) {
    this.contactData = contactData;
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() { click(By.name("submit")); }

  public void returnToHomePage() { click(By.linkText("home")); }

  public void initContactModification() { click(By.cssSelector("img[alt='Edit']")); }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.cssSelector("img[alt='Edit']"));
  }

  public void createContact(ContactData test1) {
    initContactCreation();
    fillContactForm(test1, true);
    submitContactCreation();
    returnToHomePage();
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    closeDialogWindow();
  }
}
