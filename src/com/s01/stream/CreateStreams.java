package com.s01.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStreams {

    public static <T> void show(String title,Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElement = stream.limit(SIZE+1).collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i=0;i<firstElement.size();i++){
            if (i>0 && i< SIZE) System.out.print(",");
            if (i<SIZE) System.out.print(firstElement.get(i));
            else System.out.print("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\project\\CoreJava2\\src\\com\\s01\\stream\\text.txt");
        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(content.split("\r\n"));
        show("words",words);

        Stream<String> song = Stream.of("gently","down","the","stream");
        show("song",song);

        Stream<String> silence = Stream.empty();
        show("silence",silence);

        Stream<String> echos = Stream.generate(()->"Echo");
        show("echos",echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms",randoms);

        Stream<Integer> integer = Stream.iterate(0,n->n=n+1);
        show("Integer",integer);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,n->n.add(BigInteger.ONE));
        show("intergers",integers);

        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(content);
        show("wordsAnotherWay",wordsAnotherWay);

        try (Stream<String> lines = Files.lines(path,StandardCharsets.UTF_8)){
            show("lines",lines);
        }
    }
}
