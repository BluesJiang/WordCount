package com.hust.bluesjiang;

//import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, String> Args= new HashMap<String, String>();

    public static void main(String[] args) {
//        Options opts = new Options();
//        OptionGroup optgroup = new OptionGroup();
//        opts.addOption("c",false,"count charaters");
//        opts.addOption("w",false,"count words");
//        opts.addOption("l",false,"count lines");
//        opts.addOption("h", false, "display help");
//        opts.addOption("o", true, "output file");
//
//        DefaultParser parser = new DefaultParser();
//        try {
//            CommandLine commandLine = parser.parse(opts, args);
//            if (commandLine.hasOption("h")) {
//                HelpFormatter formatter = new HelpFormatter();
//                formatter.printHelp("wc [options] [filename]", opts);
//            }
//
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//            HelpFormatter formatter = new HelpFormatter();
//            formatter.printHelp("wc [options] [filename]", opts);
//        }
        parseArgs(args);
        System.out.println(Args);
    }

    static void parseArgs(String[] args) {
        String inputFile="";
        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) == '-') {
                char arg = args[i].charAt(1);

                switch (arg) {
                    case 'c':
                    case 'w':
                    case 'l':
                        if (i+1 < args.length && args[i+1].charAt(0) != '-') {
                            inputFile = args[i+1];
                            i++;
                        }
                        Args.put(String.valueOf(arg), inputFile);
                        break;
                    case 'o':
                        if (i+1 < args.length) {
                            Args.put(String.valueOf(arg), args[i+1]);
                            i++;
                        }
                }
            } else {
                inputFile = args[i];
            }
        }
        for(String key:Args.keySet()) {
            if (Args.get(key).equals("")) {
                Args.put(key,inputFile);
            }
        }

    }
}
