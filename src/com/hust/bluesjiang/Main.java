package com.hust.bluesjiang;

//import org.apache.commons.cli.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, String> Args= new HashMap<String, String>();

    public static void main(String[] args) {
//        parseArgs(args);
        ArgParser argParser = new ArgParser();
        argParser.parse(args);
        System.out.println(argParser.target);
        WordCounter wc = new WordCounter();
        String outputStr = "";

        if (Args.containsKey("c")) {
            outputStr += Args.get("c")+", 字符数: "+wc.countChar(Args.get("c"))+"\n";
        }
        if (Args.containsKey("w")) {
            outputStr += Args.get("w")+", 单词数: "+wc.countWords(Args.get("w"))+"\n";
        }
        if (Args.containsKey("l")) {
            outputStr += Args.get("l")+", 行数: "+wc.countLines(Args.get("l"))+"\n";
        }
        if (Args.containsKey("a")) {
            long[] res = wc.countALines(Args.get("w"));
            System.out.println("" + res[0]+" "+res[1]+" "+res[2]);
        }
        if (Args.containsKey("o")) {
            try {
                FileWriter outputFile = new FileWriter(Args.get("o"));
                outputFile.write(outputStr);
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.print(outputStr);
        }
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
                    case 'a':
                    case 's':
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
