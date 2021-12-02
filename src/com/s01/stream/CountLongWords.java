package com.s01.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CountLongWords {


    //一次行按字符串读出 转为数组再遍历
    public static void main(String[] args){
        try {
            String contents  = new String(Files.readAllBytes(Paths.get("D:\\project\\CoreJava2\\src\\com\\s01\\stream\\text.txt")), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split("\r\n"));// "\\LP+"
            long count = 0;
            System.out.println(words);

            for(String w : words){
                if (w.length()>12) count++;
            }
            System.out.println(count);
        }catch (IOException e){
            System.out.println( e);
        }
    }


}
