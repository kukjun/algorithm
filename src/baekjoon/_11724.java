package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11724 {

    private static boolean visit[];
    private static LinkedList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M;
        int u, v;
        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        adjList = new LinkedList[N + 1];

        // 인접 리스트 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if (adjList[u] == null) {
                adjList[u] = new LinkedList<>();
            }
            if (adjList[v] == null) {
                adjList[v] = new LinkedList<>();
            }
            if (!adjList[u].contains(v)) {
                adjList[u].add(v);
                adjList[v].add(u);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int i) {
        visit[i] = true;
        if (adjList[i] != null) {
            for (int j : adjList[i]) {
                if (!visit[j]) {
                    dfs(j);
                }
            }
        }
    }
}
