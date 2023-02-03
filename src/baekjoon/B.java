package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws Exception {
        class PointXY {
            int x;
            int y;

            PointXY(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<PointXY> queue = new LinkedList<>();
        Queue<PointXY> startQueue = new LinkedList<>();
        int areaCount = 0;

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] area = new int[height][width];
        boolean[][] visit = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 0) {
                    startQueue.add(new PointXY(j, i));
                }
                System.out.println("area[" + i + "]["+j+"] = " + area[i][j]);
            }
        }

        while (!startQueue.isEmpty()) {
            PointXY startPoint = startQueue.poll();
            if (!visit[startPoint.y][startPoint.x]) {
                queue.add(startPoint);
                visit[startPoint.y][startPoint.x] = true;
                areaCount++;
            }

            while (!queue.isEmpty()) {
                PointXY checkPoint = queue.poll();

                for (int force = 0; force < 4; force++) {
                    int nextX = checkPoint.x + dx[force];
                    int nextY = checkPoint.y + dy[force];
                    if (nextX < 0) {
                        nextX = width-1;
                    } else if (nextX == width) {
                        nextX = 0;
                    }
                    if (nextY < 0) {
                        nextY = height-1;
                    } else if (nextY == height) {
                        nextY = 0;
                    }

                    if (!visit[nextY][nextX]) {
                        if (area[nextY][nextX] == 0) {
                            visit[nextY][nextX] = true;
                            queue.add(new PointXY(nextX, nextY));
                        }
                    }
                }
            }
        }

        System.out.println(areaCount);

    }
}
