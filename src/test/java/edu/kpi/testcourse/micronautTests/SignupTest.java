package edu.kpi.testcourse.micronautTests;

import edu.kpi.testcourse.dataModels.Credentials;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class SignupTest {

  @Inject
  @Client("/")
  RxHttpClient client;

  @Test
  void badResponse() {
    String email = "abc@gmail.com";
    String secret = "1234567";
    Credentials credentials = new Credentials(email, secret);
    HttpRequest request = HttpRequest.POST("/users/signup", credentials);
    HttpResponse response = client.toBlocking().exchange(request);

    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());
  }

  @Test
  void successfullAuthentication() {
    String email = "abc@gmail.com";
    String secret = "12345678";
    Credentials credentials = new Credentials(email, secret);
    HttpRequest request = HttpRequest.POST("/users/signup", credentials);
    HttpResponse response = client.toBlocking().exchange(request);

    Assertions.assertEquals(HttpStatus.CREATED, response.getStatus());
  }

}
