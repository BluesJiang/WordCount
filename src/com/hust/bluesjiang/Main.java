package com.hust.bluesjiang;

//import org.apache.commons.cli.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArgParser argParser = new ArgParser();
        if (argParser.parse(args) < 0) {
            System.out.println("Arguments error");
            return ;
        }
        WordCounter wc = new WordCounter();
        if (argParser.containsKey("e")) {
            wc.buildEscapeWord(argParser.get("e"));

        }
        String outputStr = "";
        for (String inputFileName:argParser.getTarget()) {
            if (argParser.containsKey("c")) {
                outputStr += inputFileName +", 字符数: "+wc.countChar(inputFileName)+"\n";
            }
            if (argParser.containsKey("w")) {
                outputStr += inputFileName +", 单词数: "+wc.countWords(inputFileName)+"\n";
            }
            if (argParser.containsKey("l")) {
                outputStr += inputFileName +", 行数: "+wc.countLines(inputFileName)+"\n";
            }
            if (argParser.containsKey("a")) {
                long[] res = wc.countALines(inputFileName);
                outputStr += inputFileName +", 代码行/空行/注释行: "+res[0]+"/"+res[1]+"/"+res[2]+"\n";
            }
        }

        if (argParser.containsKey("o")) {
            try {
                FileOutputStream fos = new FileOutputStream(new File(argParser.get("o")));
                OutputStreamWriter writer = new OutputStreamWriter(fos, "utf-8");
                writer.write(outputStr);
                writer.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.print(outputStr);
        }
    }

}
