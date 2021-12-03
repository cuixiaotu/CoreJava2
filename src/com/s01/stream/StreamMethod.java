package com.s01.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamMethod {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[]{"123", "124124", "12414"});
        Stream<String> longWords = wordList.stream().filter(w->w.length() > 4);


        List<String> words =new ArrayList<>() ;
        words.add("sdasdadasdad");
        words.add("kfgfsdklspouiuflskdfslkf");
        words.add("daksdjalksdj");


        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);

        Stream<String> firstLetters = words.stream().map(s-> s.substring(0,1));

        Stream<Object> res = words.stream().map(w-> letters(w));



        // 1.4
        Stream<String>  limit = words.stream().limit(1);
        System.out.println(limit);

        Stream<String> skip = words.stream().skip(1);
        System.out.println(skip);


        Stream<String> concat = Stream.concat(Arrays.stream(new String[]{"12312"}),skip);
        System.out.println(concat.count());



        Stream<String>  distinct = words.stream().distinct();

        Stream<String>  sorted = words.stream().sorted();

        Stream<String>  peek = words.stream().peek(s-> System.out.println(s));




        List<Integer> num =new ArrayList<>() ;
        num.add(33);
        num.add(32);
        num.add(12);

        Optional<Integer> max = num.stream().max(Integer::compareTo);
        System.out.println(max.orElse(0));

        Optional<Integer> min = num.stream().min(Integer::compareTo);
        System.out.println(min.orElse(999));

        Optional<String> startsWithQ = words.stream().filter(s->s.startsWith("Q")).findFirst();

        Optional<String> startWithQ = words.stream().parallel().filter(s->s.startsWith("Q")).findFirst();


        Optional<String> startWithQ2 = words.stream().parallel().filter(s->s.startsWith("Q")).findAny();

        Boolean aWordStartWithQ = words.stream().parallel().allMatch(s->s.startsWith("Q"));


        System.out.println(longWords);
        System.out.println(lowercaseWords);
        System.out.println(firstLetters);
        System.out.println(res.count());

    }

    public static Stream<String> letters(String s){
        List<String> result = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            result.add(s.substring(i,i+1));
        }
        return result.stream();
    }

}
