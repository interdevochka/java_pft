package appmanager;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
    attach(By.name("photo"), contactData.getPhoto());

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
      String allPhones = contactEntryList.get(5).getText();
      String allEmails = contactEntryList.get(4).getText();
      String address = contactEntryList.get(3).getText();
      int id = Integer.parseInt(contactEntryList.get(0).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact =
              new ContactData().withId(id).withFirstName(firstName).withLastName(secondName)
                      .withGroup(null).withAllEmails(allEmails).withAllPhones(allPhones).withAddress(address);
      contactCach.add(contact);
    }
    return new Contacts(contactCach);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
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
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }
}
