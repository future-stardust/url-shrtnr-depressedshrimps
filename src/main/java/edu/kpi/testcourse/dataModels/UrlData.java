package edu.kpi.testcourse.dataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlData {
  private @JsonProperty String fullURL;
  private @JsonProperty String alias;

  public UrlData(String fullURL, String alias) {
    this.fullURL = fullURL;
    this.alias = alias;
  }

  public void shorten() {
    /* shortening implementation */
  }

}
