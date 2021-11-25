package com.s01.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StreamTest2 {

    public static void main(String[] args) throws IOException {
        String contents  = new String(Files.readAllBytes(Paths.get("D:\\project\\CoreJava2\\src\\com\\s01\\stream\\text.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\r\n"));// "\\LP+"
        // long count = words.stream().filter(w->w.length()>12).count();//串行
        // System.out.println(words.stream());
        long count = words.parallelStream().filter(w->w.length()>12).count();//并行
        System.out.println(count);
    }
}
