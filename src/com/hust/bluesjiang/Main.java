package com.hust.bluesjiang;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) {
        Options opt = new Options();
        opt.addOption("c",false,"count charaters");
        opt.addOption("w",false,"count words");
        opt.addOption("h", false, "display help");

        DefaultParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(opt, args);
            if (commandLine.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("wc [options] [filename]", opt);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
