package ru.stqa.pft.rest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppManager {
  private final Properties properties;

  public AppManager() {
    properties = new Properties();
  }

  public void init() throws IOException {
    properties.load(new FileReader(new File("src/test/resources/local.properties")));
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
