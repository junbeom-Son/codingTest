/**
 * 토마토 모두 익히기
 * 입력 : 상자의 가로 길이 M, 세로 길이 N, N x M개의 토마토 정보
 * 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 빈칸
 * 출력 : 토마토가 모두 익을 때까지 걸리는 최소 날짜, 토마토가 모두 익지 못하는 상황이면 -1
 * 1. 익은 토마토, 익지 않은 토마토, 빈칸의 개수 각각 파악
 * 2. 익은 토마토의 위치에서 익지 않은 토마토의 위치로 접근(bfs 기법 사용)
 * 2-1. 접근한 적이 없다면 익은 토마토의 시간 + 1 기록
 * 2-2. 접근한 적이 있다면 익은 토마토의 시간 + 1이 이전에 접근한 시간보다 더 짧으면 접근
 * 3. 접근이 완료 된 후, 익지 않은 토마토가 있다면 -1 출력
 * 없다면 최소 시간 출력
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576_토마토 {
    static int N;
    static int M;
    static int[][] tomatoes;
    static int[][] times;
    static final int[] X_DIRECTION = {0, 0, -1, 1};
    static final int[] Y_DIRECTION = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        times = new int[N][M];
        for (int[] row : times) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        System.out.println(getRipenTime(N, M));
    }

    private static int getRipenTime(int N, int M) {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (tomatoes[i][j] == 1) {
                    times[i][j] = 0;
                    queue.offer(new Point(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.row;
            int column = point.column;
            int time = times[row][column];
            for (int i = 0; i < 4; ++i) {
                addQueue(queue, row + Y_DIRECTION[i], column + X_DIRECTION[i], time);
            }
        }
        int furthestTime = -1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (tomatoes[i][j] == 0) {
                    return -1;
                }
                if (times[i][j] > furthestTime) {
                    furthestTime = times[i][j];
                }
            }
        }
        return furthestTime;
    }

    private static void addQueue(Queue<Point> queue, int row, int column, int time) {
        if (row < 0 || row >= N || column < 0 || column >= M) {
            return;
        }
        if (tomatoes[row][column] == 0) {
            tomatoes[row][column] = 1;
            times[row][column] = time + 1;
            queue.offer(new Point(row, column));
        }
    }
}

class Point {
    int row;
    int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }
}