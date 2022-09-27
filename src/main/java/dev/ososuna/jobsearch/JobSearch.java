package dev.ososuna.jobsearch;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.beust.jcommander.JCommander;

import dev.ososuna.jobsearch.api.ApiFunctions;
import dev.ososuna.jobsearch.api.ApiJobs;
import dev.ososuna.jobsearch.cli.CliArguments;
import dev.ososuna.jobsearch.cli.CliFunctions;
import dev.ososuna.jobsearch.cli.CommanderFunctions;
import dev.ososuna.jobsearch.model.JobPosition;

public class JobSearch {
  public static void main(String[] args) {
    JCommander jCommander = CommanderFunctions.buildCommanderWithName(
      "job-search",
      CliArguments::newInstance
    );
    Stream<CliArguments> streamOfCli =
      CommanderFunctions.parseArguments(jCommander, args, JCommander::usage)
      .orElse(Collections.emptyList())
      .stream()
      .map(object -> (CliArguments) object);
    Optional<CliArguments> cliArgumentsOptional =
      streamOfCli.filter(cli -> !cli.isHelp())
      .filter(cli -> cli.getKeyword() != null)
      .findFirst();
    cliArgumentsOptional.map(CliFunctions::toMap)
      .map(JobSearch::executeRequest)
      .orElse(Stream.empty())
      .forEach(System.out::println);
  }

  private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
    ApiJobs apiJobs = ApiFunctions.buildApi(ApiJobs.class, "https://jobs.github.com");
    return Stream.of(params)
      .map(apiJobs::jobs)
      .flatMap(Collection::stream);
  }
}
