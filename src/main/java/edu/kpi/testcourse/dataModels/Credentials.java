package edu.kpi.testcourse.dataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
  private @JsonProperty String email;
  private @JsonProperty String secret;

  public Credentials(@JsonProperty("email") String email, @JsonProperty("secret") String secret) {
    this.email = email;
    this.secret = secret;

  }

  public String validation() {
    if (email.isEmpty() || secret.isEmpty()) {
      return "empty credentials";
    }
    if (!(email.contains("@gmail.com")) || !(email.contains("@mail.net")) || !(email.contains("@ukr.net"))) {
      return "wrong email format";
    }
    if (secret.length() > 15 || secret.length() < 8) {
      return "incorrect password length";
    }
    return "all good";
  }

}
