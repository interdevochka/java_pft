package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;


public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.IE);
  @BeforeSuite(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();

  }

}
