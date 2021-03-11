package edu.kpi.testcourse.micronautTests;

import edu.kpi.testcourse.dataModels.Credentials;
import edu.kpi.testcourse.dataModels.UrlData;
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
public class ShortenTest {

  @Inject
  @Client
  RxHttpClient client;

  @Test
  void okResponse() {
    String fullURL = "/abc/";
    String alias = "";
    UrlData urlData = new UrlData(fullURL, alias);
    HttpRequest request = HttpRequest.POST("/login", urlData);
    HttpResponse response = client.toBlocking().exchange(request);

    Assertions.assertEquals(HttpStatus.OK, response.getStatus());
  }

}
