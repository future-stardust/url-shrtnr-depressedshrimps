package edu.kpi.testcourse.rest;

import edu.kpi.testcourse.dataModels.Credentials;
import edu.kpi.testcourse.dataModels.UrlData;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;


@Controller
public class ApiController {

  @Get(value = "/hello", produces = MediaType.APPLICATION_JSON)
  public String hello() {
    return "Hello world!";
  }

  @Post(value = "/users/signup", consumes = MediaType.APPLICATION_JSON)
  public HttpResponse<String> signup(@Body Credentials credentials) {
    String response = credentials.validation();

    if (!(response.equals("all good"))) {
      return HttpResponse.badRequest(response);
    }

    /* here should be the bit about checking if the user is already registered and adding him to db */

    return HttpResponse.created("We have not implemented this yet, but consider yourself registered");
  }

  @Post(value = "/login", consumes = MediaType.APPLICATION_JSON)
  public HttpResponse<String> login(@Body Credentials credentials) {
    String response = credentials.validation();

      if (!(response.equals("all good"))) {
        return HttpResponse.badRequest(response);
      }

      /* Here should be the bit about checking if the user is registered and whether the credentials are okay */

      return HttpResponse.ok();
  }

  @Post(value = "/urls/shorten", consumes = MediaType.TEXT_PLAIN)
  public HttpResponse<String> shorten(@Body UrlData urlData) {
    urlData.shorten();
    return HttpResponse.ok();
  }

}
