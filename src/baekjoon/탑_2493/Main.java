package baekjoon.탑_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Top {
        int index;
        int height;

        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        Stack<Top> stack = new Stack<>();
        for (int i = 1; i <= count; i++) {
            int currentTopHeight = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                Top stackTop = stack.peek();
                if (stackTop.height > currentTopHeight) {
                    sb.append(stackTop.index).append(" ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            stack.push(new Top(i, currentTopHeight));
        }

        System.out.println(sb);
    }
}
