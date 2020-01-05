package appmanager;

import model.ContactData;
import model.Contacts;
import model.GroupData;
import model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  private ContactData contactData;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    this.contactData = contactData;
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getSecondName());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void initContactModification(int id) {
    wd.findElements(By.cssSelector("img[alt='Edit']")).get(0).click(); //todo как правильно искать по id??
  }

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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    closeDialogWindow();
  }

  private Contacts contactCach = null;

  public Contacts all() {
    if (contactCach != null) {
      return new Contacts(contactCach);
    }
    contactCach = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> contactEntryList = element.findElements(By.cssSelector("td"));
      String firstName = contactEntryList.get(2).getText();
      String secondName = contactEntryList.get(1).getText();
      int id = Integer.parseInt(contactEntryList.get(0).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(firstName).withSecondName(secondName).withGroup(null);
      contactCach.add(contact);
    }
    return new Contacts(contactCach);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    return null;
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCach = null;
    returnToHomePage();
  }

  public int count() {
    return wd.findElements(By.name("entry")).size();
  }

  public void delete(ContactData deletedContact) {
    selectContactById(deletedContact.getId());
    deleteSelectedContacts();
    contactCach = null;
    returnToHomePage();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }
}
