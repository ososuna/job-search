package dev.ososuna.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CliKeywordValidator implements IParameterValidator {

  @Override
  public void validate(String name, String value) throws ParameterException {
    if (!value.matches("^[a-zA-Z0-9]+$")) {
      System.err.println("The search criteria is not valid");
      throw new ParameterException("Keyword must be alphanumeric");
    }
  }
}
