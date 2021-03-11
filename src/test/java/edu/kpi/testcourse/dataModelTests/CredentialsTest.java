package edu.kpi.testcourse.dataModelTests;

import edu.kpi.testcourse.dataModels.Credentials;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CredentialsTest {

  @Test
  public void emptyCredentials() {
    String email = "";
    String secret = "";

    Credentials credentials = new Credentials(email, secret);

    String response = credentials.validation();

    Assertions.assertEquals("empty credentials", response);
  }

  @Test
  public void wrongEmailFormat() {
    String email = "abc";
    String secret = "12345678";

    Credentials credentials = new Credentials(email, secret);

    String response = credentials.validation();

    Assertions.assertEquals("wrong email format", response);
  }

  @Test
  public void wrongPasswordLength() {
    String email = "abc@gmail.com";
    String secret = "1234";

    Credentials credentials = new Credentials(email, secret);

    String response = credentials.validation();

    Assertions.assertEquals("incorrect password length", response);
  }

  @Test
  public void goodCredentials() {
    String email = "abc@gmail.com";
    String secret = "12345678";

    Credentials credentials = new Credentials(email, secret);

    String response = credentials.validation();

    Assertions.assertEquals("all good", response);
  }

}
