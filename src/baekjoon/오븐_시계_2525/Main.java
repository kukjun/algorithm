package baekjoon.오븐_시계_2525;

import java.io.*;
import java.util.Arrays;

public class Main {

    static int HOUR_LIMIT = 24;
    static int MINUTE_LIMIT = 60;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cookTime = Integer.parseInt(br.readLine());

        time[0] += (cookTime + time[1]) / MINUTE_LIMIT;
        time[0] %= HOUR_LIMIT;
        time[1] = (cookTime + time[1]) % MINUTE_LIMIT;
        System.out.println(time[0] + " " + time[1]);

    }
}


