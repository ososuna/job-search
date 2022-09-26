package dev.ososuna.jobsearch.api;

import java.util.List;
import java.util.Map;

import dev.ososuna.jobsearch.model.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface ApiJobs {
  @RequestLine("GET /positions.json")
  List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
}
