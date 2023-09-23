package baekjoon.꼬마_정민_11382;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = Arrays.stream(Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray()).sum();

        System.out.println(result);
    }
}


