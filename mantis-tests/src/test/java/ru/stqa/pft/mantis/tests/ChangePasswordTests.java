package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException {
    String adminUser = app.getProperty("web.adminLogin");
    String adminPassword = app.getProperty("web.adminPassword");
    app.login().start(adminUser, adminPassword);
    app.usersHelper().goToManageUsersPage();
    User user = app.dbHelper().users().stream()
            .filter(u -> !u.getUsername().equals(adminUser)).findFirst().orElseThrow(IllegalStateException::new);
    app.usersHelper().resetPasswordStart(user.getId());
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 20000);
    String email = user.getEmail();
    String confirmationLink = app.mail().findConfirmationLink(mailMessages, email);
    String newPassword = "new_password";
    app.usersHelper().resetPasswordFinish(confirmationLink, newPassword);
    assertTrue(app.newSession().login(user.getUsername(), newPassword));
  }


  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
