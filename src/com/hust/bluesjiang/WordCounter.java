package com.hust.bluesjiang;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * WordCount
 * Created by Blues on 2018/3/15.
 */
public class WordCounter {
    HashSet<String> escapeWord;
    WordCounter() {}

    public long countChar(String filename) {
        long count = 0;
        try {
            FileReader file = new FileReader(filename);
            int c = file.read();
            while(c != -1) {
                count ++;
                c = file.read();
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return count;
    }

    public void buildEscapeWord(String filename) {
        this.escapeWord = new HashSet<String>();
        try {
            FileReader file = new FileReader(filename);
            int ch = file.read();
            while (ch != -1) {
                String word = "";
                while (ch != -1 && isSep((char)ch)) {
                    ch = file.read();
                }
                while(ch != -1 && !isSep((char) ch)) {
                    word += String.valueOf((char)ch);
                    ch = file.read();
                }
                this.escapeWord.add(word);
                if (ch == -1)break;
                ch = file.read();
            }
            file.close();
//            System.out.println(this.escapeWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countWords(String filename) {
        long count = 0;
        try {
            FileReader file = new FileReader(filename);
            int ch = file.read();
            while (ch != -1) {
                String word = "";
                while (ch != -1 && isSep((char)ch)) {
                    ch = file.read();
                }
                while (ch != -1 && !isSep((char)ch)) {
                    word += String.valueOf((char)ch);
                    ch = file.read();
                }
                count++;
                if (this.escapeWord != null && this.escapeWord.contains(word)) {
                    count--;
                }
                ch = file.read();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public long countLines(String filename) {
        long count = 0;
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            while (file.readLine() != null) {
                count ++;
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    public long[] countALines(String filename) {
        long[] lines = {0,0,0};
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            String line = file.readLine();
            boolean intoComment = false;
            while (line != null) {
                long charCount = 0;
                boolean hasComment = false;
                if (intoComment) hasComment = intoComment;
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch == ' ' || ch == '\t' || ch == '\n') {
                        continue;
                    }
                    else if (line.charAt(i) == '/' && intoComment == false) {
                        if (i + 1 != line.length()) {
                            if (line.charAt(i+1) == '*') {
                                intoComment = true;
                                hasComment = true;
                                i++;
                            } 
                            else if (line.charAt(i+1) == '/' ) {
                                hasComment = true;
                                break;
                            } else charCount++;
                        }
                    }
                    else if (line.charAt(i) == '*' && intoComment == true) {
                        if (i + 1 != line.length()) {
                            if (line.charAt(i+1) == '/') {
                                intoComment = false;
                                i++;
                            }
                        } else charCount++;
                    }
                    else {
                        if (intoComment == false) {
                            charCount++;
                        }
                    }
                }
                if (charCount == 0) {
                    if (hasComment) {
                        lines[2]++;
                    } else {
                        lines[1]++;
                    }
                } else if (charCount == 1) {
                    if (hasComment) {
                        lines[1]++;lines[2]++;
                    } else lines[1]++;
                } else {
                    lines[0]++;
                }
                line = file.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private boolean isSep(char c){
        if (c == ' ' || c == ',' || c == '\n') {
            return true;
        } else  {
            return false;
        }
    }
}
