package main.java.com.app;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Integer[] table = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int iterativeSum = 0;

        for (int i = 0; i < table.length; i++) {
            iterativeSum += table[i];
        }

        List<Integer> list = Arrays.asList(table);

        int functionalSum = list
                .stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(iterativeSum);
        System.out.println(functionalSum);
    }
}
