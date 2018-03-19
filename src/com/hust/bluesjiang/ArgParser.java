package com.hust.bluesjiang;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

/**
 * WordCount
 * Created by Blues on 2018/3/18.
 */
public class ArgParser {
    HashMap<String, String> args = new HashMap<>();
    public ArrayList<String> target = new ArrayList<String>();
    String exten = "";
    public ArgParser(){}
    void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) == '-') {
                char arg = args[i].charAt(1);

                switch (arg) {
                    case 'c':
                    case 'w':
                    case 'l':
                    case 'a':
                    case 's':
                        this.args.put(String.valueOf(arg), "");
                        break;
                    case 'o':
                    case 'e':
                        if (i+1 < args.length) {
                            this.args.put(String.valueOf(arg), args[i+1]);
                            i++;
                        }
                        break;


                }
            } else {
                this.target.add(args[i]);
            }
        }
        if (this.args.containsKey("s")) {
            String filePath = this.target.remove(0);
//            this.exten = this.exten.substring(1);
            String os = System.getProperty("os.name");
//            System.out.println(os);
            String sep;

            if(os.toLowerCase().startsWith("win")){
                sep = "\\\\";
            } else {
                sep = "/";
            }
            String[] comp = filePath.split(sep);
            this.exten = comp[comp.length-1].substring(1);
            buildTaget(".");
            buildTaget(filePath);

        }
    }

    void buildTaget(String path) {
        if (this.args.containsKey("s")) {
            File dir = new File(path);
            if (dir.exists()) {
                File[] files = dir.listFiles();
                for (File file:files) {
                    if (file.isDirectory()) {
                        buildTaget(file.getAbsolutePath());
                    }
                    if (file.isFile()) {
                        String name = file.getAbsolutePath();
                        if (name.endsWith(this.exten)) {
                            this.target.add(name);
                        }
                    }
                }

            }
        }
    }
    public String[] get(String key) {
        if (args.containsKey(key)) {
            if (args.get(key).equals("")) {
                return target.toArray(new String[target.size()]);
            }
            else {
                return new String[];
            }
        }
    }


}
