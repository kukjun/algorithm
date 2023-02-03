package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2839 {

    static final int smallBox = 3;
    static final int largeBox = 5;

    public static void main(String[] args) throws IOException {

        String[] input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer("1 2 3 4 5", " ");

        int N = Integer.parseInt(input[0]);

        if (N == 3) {
            System.out.println(1);
            return;
        } else if (N == 4) {
            System.out.println(-1);
            return;
        } else if (N == 5) {
            System.out.println(1);
            return;
        }

        boolean[] visit = new boolean[N + 1];
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(smallBox);
        queue.add(largeBox);
        visit[smallBox] = true;
        visit[largeBox] = true;
        count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int var = queue.poll().intValue();
                if (var == N) {
                    System.out.println(count);
                    return;
                }
                int[] nextVars = new int[2];
                nextVars[0] = var + smallBox;
                nextVars[1] = var + largeBox;
                for (int nextVar : nextVars) {
                    if (nextVar < visit.length && !visit[nextVar]) {
                        queue.add(nextVar);
                        visit[nextVar] = true;
                    }
                }
            }
            count++;
        }

        count = -1;
        System.out.println(count);
    }
}
