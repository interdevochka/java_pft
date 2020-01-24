package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UsersHelper extends HelperBase {
  public UsersHelper(ApplicationManager app) {
    super(app);
  }

  public void goToManageUsersPage() {
    wd.get(app.getProperty("web.baseUrl") + "manage_user_page.php");
  }

  public void resetPasswordStart(int id) {
    wd.get(app.getProperty("web.baseUrl") + String.format("manage_user_edit_page.php?user_id=%s", id));
    click(By.xpath("//input[@value='Reset Password']"));
  }

  public void resetPasswordFinish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//button[@type='submit']"));
  }
}
