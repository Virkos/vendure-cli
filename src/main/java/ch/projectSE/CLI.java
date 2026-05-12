package ch.projectSE;

import picocli.CommandLine.Command;

@Command(
        name = "vendure-cli",
        description = "CLI to interact with the Vendure server",
        subcommands = {ListCommand.class},
        mixinStandardHelpOptions = true)

public class CLI implements Runnable {

    @Override
    public void run() {
        System.out.println("Use a subcommand. Example : vendure-cli list");
    }
}
