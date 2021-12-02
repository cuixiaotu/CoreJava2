package com.s01.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTest {

    public static void main(String[] args) throws IOException {

        //1.7.1
 //      Optional<String> optionalString = Optional.of("1231");

//        String orElse = optionalString.orElse("");
//
//        String orElseGet = optionalString.orElseGet(()-> Locale.getDefault().getDisplayName());
//
//        String orElseThrow = optionalString.orElseThrow(IllegalStateException::new);
//
//
//        List<String> res = new ArrayList<>();
//        optionalString.ifPresent(v->res.add(v));
//
//        Optional<Boolean> added = optionalString.map(res::add);
//
//
//        System.out.println(orElse);
//        System.out.println(orElseGet);
//        System.out.println(orElseThrow);
//
//        System.out.println(res);
//        System.out.println(added);

        //1.7.2

//        System.out.println(optionalString.get());
//
//        if (optionalString.isPresent()) {
//            System.out.println( optionalString.get() );
//        }


        //1.7.3

//        Optional<String> emptyOptional = Optional.empty();
//        System.out.println(emptyOptional);
//
//        Optional<String> notNullOptional = Optional.ofNullable("");
//        System.out.println(notNullOptional);


        //1.7.4
       // Optional<>
        String contents = new String(Files.readAllBytes(Paths.get("D:\\project\\CoreJava2\\src\\com\\s01\\stream\\text.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\r\n"));

        Optional<String> optionalValue = wordList.stream().filter(s->s.contains("fred")).findFirst();
        System.out.println(optionalValue.orElse("No Word") + " contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println(" result:" + result);

        result = optionalString.orElseGet(()-> Locale.getDefault().getDisplayName());
        System.out.println(" result:" + result);

        try {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println(" result:" + result);
        }catch (Throwable t){
            t.printStackTrace();
        }

        optionalValue = wordList.stream().filter(s->s.contains("red")).findFirst();
        optionalValue.ifPresent(s-> System.out.println(s + " contain red" ));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);

        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));

        Optional<Double> result2 = Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);


    }


    public static Optional<Double> inverse(Double x){
        return x == 0? Optional.empty() : Optional.of(1/x);
    }

    public static Optional<Double> squareRoot(Double x){
        return x<0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
