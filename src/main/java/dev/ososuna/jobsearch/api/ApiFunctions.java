package dev.ososuna.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface ApiFunctions {
  public static<T> T buildApi(Class<T> clazz, String url) {
    return Feign.builder()
      .decoder(new GsonDecoder())
      .target(clazz, url);
  }
}
