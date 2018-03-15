package com.hust.bluesjiang;
import java.io.FileReader;
import java.io.IOException;

/**
 * WordCount
 * Created by Blues on 2018/3/15.
 */
public class WordCounter {
    private String filename;
    WordCounter(String filename) {
        this.filename = filename;
    }
    public long countChar() {
        long count = 0;
        try {
            FileReader file = new FileReader(filename);
            int c = file.read();
            while(c != -1) {
                System.out.print((char)c);
                count += isSep((char)c)?0:1;
                c = file.read();
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return count;
    }

    private boolean isSep(char c){
        if (c == ' ' || c == ',' || c == '\t' || c == '\n') {
            return true;
        } else  {
            return false;
        }
    }

}
