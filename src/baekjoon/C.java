package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class C {
    public static int N;
    public static int M;
    public static int[][] W;
    public static int[] A;
    public static int[] B;

    public static int maxResult = 0;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        B = new int[M + 1];
        W = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < C+1; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < A.length; i++) {
            handShake(i, 0);
        }
        System.out.println(maxResult);

    }

    private static int handShake(int currentA, int lastHandshake) {
        int result = 0;
        if (currentA == A.length) {
            if (result > maxResult) {
                maxResult = result;
            }
            return 0;
        }
        for (int i = 1; i < B.length; i++) {
            if (lastHandshake < i) {
                result = W[A[currentA]][B[i]] + handShake(currentA + 1, i);
                if (result > maxResult) {
                    maxResult = result;
                }
            }
        }

        return result;
    }


}
