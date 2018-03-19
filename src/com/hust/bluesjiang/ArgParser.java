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
    int parse(String[] args) {
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
                        } else {
                            System.out.println(args[i] + "must follow a file");
                            return -1;
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
            if (!comp[comp.length-1].startsWith("*")) {
                System.out.println("File must start with '*'");
            }
            this.exten = comp[comp.length-1].substring(1);
            if (comp.length == 1) {
                return buildTarget(".");
            } else {
                char pathsep;
                if(os.toLowerCase().startsWith("win")){
                    pathsep = '\\';
                } else {
                    pathsep = '/';
                }
                return buildTarget(filePath.substring(0,filePath.lastIndexOf(pathsep)));
            }
        }
        return 0;
    }

    int buildTarget(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file:files) {
                if (file.isDirectory()) {
                    return buildTarget(file.getPath());
                }
                if (file.isFile()) {
                    String name = file.getPath();
                    if (name.endsWith(this.exten)) {
                        this.target.add(name);
                    }
                }
            }
        } else {
            System.out.println("No such file or directory: "+path);
            return -1;
        }
        return 0;
    }
    public String[] getTarget() {
        return target.toArray(new String[target.size()]);
    }
    public boolean containsKey(String key) {
        return args.containsKey(key);
    }
    public String get(String key) {
        if (args.containsKey(key)) {
            return args.get(key);
        } else {
            return null;
        }
    }


}
