package com.ksgbabu.intramind.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by gireeshbabu on 22/02/16.
 */
@Component
public class RoutineCommands implements CommandMarker {

    protected final Logger logger = LoggerFactory.getLogger(RoutineCommands.class);

    @CliAvailabilityIndicator({"mail"})
    public boolean isCommandAvailable() {
        return true;
    }

    @CliCommand(value = "mail", help = "Will open the mail application")
    public String simple(
            @CliOption(key = { "message" }, mandatory = false, help = "The hello world message")
            final String message,
            @CliOption(key = { "location" }, mandatory = false, help = "Where you are saying hello", specifiedDefaultValue="At work")
            final String location)
            {
                return "Message = ["
                        + message +
                        "] Location = ["
                        + location +
                        "]";
        }

    @CliCommand(value = "open", help = "Opens the specified application")
    public String open(
            @CliOption(key={"app"}, mandatory = true, help ="The name of the application to be opened") String appName
    ){
        try {
            Runtime.getRuntime().exec("open -a "+appName);
        } catch (IOException e) {
            return "Command Failed";
        }
        return "Command Executed Successfully";

    }

}
