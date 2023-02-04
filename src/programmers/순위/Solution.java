package programmers.순위;

class Solution {
    public int solution(int n, int[][] results) {

        int[][] graph = new int[n][n];

        for (int[] result : results) {
            graph[result[0]-1][result[1]-1] = 1;
            graph[result[1]-1][result[0]-1] = -1;
        }

        // A-B에게 이기고, B-C에게 이기면, A-C는 이긴다.
        // A-B에게 지고, B-C에게 지면, A-C에게 진다.

        // 첫번 째, 거쳐갈 노드 정하기
        for (int i = 0; i < n; i++) {
            // 두 번째, 내부적으로 거쳐갈 노드를 선정하기
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (graph[j][k] == 0) {
                        if (graph[j][i] == 1 && graph[i][k] == 1) {
                            graph[j][k] = 1;
                        }
                        else if (graph[j][i] == -1 && graph[i][k] == -1) {
                            graph[j][k] = -1;
                        }
                    }

                }
            }
        }

        // 결과 중 승패가 모두 정해진 경우 Count
        int count = 0;
        for (int[] line : graph) {
            int checkZero = 0;
            for (int var : line) {
                if (var == 0) {
                    checkZero++;
                }
            }
            if (checkZero == 1) {
                count++;
            }
        }

        return count;
    }
}