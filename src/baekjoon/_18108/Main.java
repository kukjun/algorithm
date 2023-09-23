package baekjoon._18108;

import java.io.*;

public class Main {

    static int MINUS_YEAR = 543;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 불가 년도 - buddhist year
        int buddhistYear = Integer.parseInt(br.readLine());

        System.out.println(buddhistYear - MINUS_YEAR);
    }
}


