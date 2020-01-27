package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

  AppManager app = new AppManager();

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws IOException {
    app.init();
  }

  Executor getExecutor() {
    return Executor.newInstance().auth(app.getProperty("api.key"), "");
  }

  private boolean isIssueOpen(int issueId) throws IOException {
    String json = getExecutor().execute(Request.Get(app.getProperty("api.baseUrl") + issueId + ".json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issueJson = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0);
    Issue issue = new Gson().fromJson(issueJson, Issue.class);
    String issueResolved = issue.getResolved();
    return issueResolved == null || issueResolved.isEmpty();
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
