package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 개수입력
        int N = Integer.parseInt(br.readLine());

        // 정수 저장할 배열 생성
        int[] rightStatueIntegers = new int[N];
        int[] leftStatueIntegers = new int[N];

        // 정수입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (st.hasMoreTokens()) {
            int statue = Integer.parseInt((st.nextToken()));
            if (statue == 1) {
                leftStatueIntegers[i] = 1;
                rightStatueIntegers[i] = -1;
            } else {
                leftStatueIntegers[i] = -1;
                rightStatueIntegers[i] = 1;
            }
            i++;
        }

        // 연속되는 값들 중 큰 값을 저장하는 maxDp 배열 생성
        // 1이라고 적힌 불상이 1이라고 보는 경우
        int[] rightDp = new int[N];
        rightDp[0] = rightStatueIntegers[0];
        for (int j = 1; j < rightDp.length; j++) {
            rightDp[j] = Math.max(rightDp[j - 1] + rightStatueIntegers[j], rightStatueIntegers[j]);
        }
        Arrays.sort(rightDp);

        // 2라고 적힌 불상이 1이라고 보는 경우
        int[] leftDp  = new int[N];
        leftDp[0] = leftStatueIntegers[0];
        for (int j = 1; j < rightDp.length; j++) {
            leftDp[j] = Math.max(leftDp[j - 1] + leftStatueIntegers[j], leftStatueIntegers[j]);
        }
        Arrays.sort(leftDp);

        System.out.println(Math.max(leftDp[N - 1], rightDp[N - 1]));

    }
}
