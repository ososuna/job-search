package dev.ososuna.jobsearch;

import com.beust.jcommander.JCommander;

import dev.ososuna.jobsearch.cli.CliArguments;
import dev.ososuna.jobsearch.cli.CommanderFunctions;

public class JobSearch {
  public static void main(String[] args) {
    JCommander jCommander =
    CommanderFunctions.buildCommanderWithName(
      "job-search",
      CliArguments::newInstance
    );
  }
}
