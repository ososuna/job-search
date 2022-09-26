package dev.ososuna.jobsearch.cli;

import com.beust.jcommander.Parameter;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CliArguments {
  
  CliArguments() {

  }
  
  @Parameter(
    required = true,
    descriptionKey = "Keyword",
    description = "Keyword"
  )
  private String keyword;

  @Parameter(
    names = {"-l", "--location"},
    description = "Each search can include a location parameter which will restrict the results to only jobs within the specified location. When a location is not provided, results are given for all locations. The location value can be a city, zip code, or other location string. If the location is not recognized, a best guess is performed based on the provided string. This parameter is ignored for non-US countries."
  )
  private String location;

  @Parameter(
    names = {"-p", "--page"},
    description = "The API returns 50 results per page. To retrieve additional results, use the page parameter. An integer page number, starting at 1. Defaults to 1."
  )
  private int page = 0;

  @Parameter(
    names = {"-f", "--full-time"},
    description = "If you want to limit results to full time positions set this parameter to true. Defaults to false."
  )
  private boolean isFullTime = false;

  @Parameter(
    names = {"--markdown"},
    description = "If you want to format the output in markdown set this parameter to true. Defaults to false."
  )
  private boolean isMarkdown = false;

  @Parameter(
    names = {"--help", "-h"},
    help = true,
    description = "Print this help message."
  )
  private boolean isHelp = false;

  public static CliArguments newInstance() {
    return new CliArguments();
  }
}
