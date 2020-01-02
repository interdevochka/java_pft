package ru.stqa.pft.sandbox;

import java.util.ArrayList;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = new ArrayList<String>();
    languages.add("Java")

    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
