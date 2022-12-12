/**
 * 최소 배추흰지렁이 마리 수 구하기
 * 입력 : 배추밭의 가로 길이 M, 세로 길이 N, 배추가 심어져 있는 위치의 개수 K, K개의 배추 위치
 * 출력 : 최소의 배추 흰지렁이 마리수
 * 배추위치 표시
 * 인접한 배추들의 그룹 개수 파악(dfs 사용)
 */

package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1012_유기농배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean[][] field = new boolean[N][M];
            boolean[][] visited = new boolean[N][M];
            int[][] cabbageInfo = new int[K][2];
            for (int j = 0; j < K; ++j) {
                st = new StringTokenizer(br.readLine());
                cabbageInfo[j][1] = Integer.parseInt(st.nextToken());
                cabbageInfo[j][0] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < K; ++j) {
                field[cabbageInfo[j][0]][cabbageInfo[j][1]] = true;
            }
            System.out.println(getCount(field, visited));
        }
        br.close();
    }

    static int getCount(boolean[][] field, boolean[][] visited) {
        int count = 0;
        for (int i = 0; i < field.length; ++i) {
            for (int j = 0; j < field[i].length; ++j) {
                if (field[i][j] && !visited[i][j]) {
                    count++;
                    findGroup(field, visited, i, j);
                }
            }
        }
        return count;
    }

    static void findGroup(boolean[][] field, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        if (col > 0) { // 왼쪽 끝이 아니라면
            if (field[row][col - 1] && !visited[row][col - 1]) {
                findGroup(field, visited, row, col - 1);
            }
        }
        if (col < field[0].length - 1) { // 오른쪽 끝이 아니라면
            if (field[row][col + 1] && !visited[row][col + 1]) {
                findGroup(field, visited, row, col + 1);
            }
        }
        if (row > 0) { // 젤 위쪽이 아니라면
            if (field[row - 1][col] && !visited[row - 1][col]) {
                findGroup(field, visited, row - 1, col);
            }
        }
        if (row < field.length - 1) { // 젤 아래쪽이 아니라면
            if (field[row + 1][col] && !visited[row + 1][col]) {
                findGroup(field, visited, row + 1, col);
            }
        }
    }
}
