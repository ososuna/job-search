package dev.ososuna.jobsearch.cli;

import java.util.function.Supplier;

import com.beust.jcommander.JCommander;

public class CommanderFunctions {
  public static <T> JCommander buildCommanderWithName(
    String cliName,
    Supplier<T> argumentSupplier
  ) {
    JCommander jCommander = JCommander.newBuilder()
      .addCommand(argumentSupplier.get())
      .build();
    jCommander.setProgramName(cliName);
    return jCommander;
  }
}
