package programmers.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {

        boolean[][] visit = new boolean[maps.length][maps[0].length];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0));
        Point target = new Point(maps[0].length-1, maps.length-1);
        int resultMove = bfs(visit, 2, queue, target, maps);

        return resultMove;
    }

    int bfs(boolean[][] visit, int count, Queue<Point> queue, Point target, int[][] maps) {
        int[][] move = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Point point = queue.poll();
            for (int[] nextMove : move) {
                int moveX = point.x + nextMove[0];
                int moveY = point.y + nextMove[1];

                // 목표와 같은지 확인하기
                if (target.x == moveX && target.y == moveY) {
                    return count;
                }

                // 벽이 없고, 맵 안에 있고, 안에 있고 방문하지 않았으면 queue에 추가하기
                if (moveX < maps[0].length && moveX >= 0 &&
                        moveY < maps.length && moveY >= 0) {
                    if(maps[moveY][moveX] == 1) {
                        if (!visit[moveY][moveX]) {
                            visit[moveY][moveX] = true;
                            queue.add(new Point(moveX, moveY));
                        }
                    }
                }
            }
        }
        // 모든 경우를 돌았는데도, queue가 비어있으면 더 이상 갈 수 없음
        if (queue.size() == 0) {
            return -1;
        } else {
            return bfs(visit, count + 1, queue, target, maps);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] maps =
                {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int result = solution.solution(maps);

        System.out.println("result = " + result);

    }
}
