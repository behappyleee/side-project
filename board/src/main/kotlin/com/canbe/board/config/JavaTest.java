package com.canbe.board.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaTest {

    public static void main(String[] args) {
        long startCurrentMills = System.currentTimeMillis();

        Long sum = 0L;

        for (long i=0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }

        long endCurrentMills = System.currentTimeMillis();

        System.out.println(sum);
        System.out.println("소요 시간 : " + (endCurrentMills - startCurrentMills));

    }
}
