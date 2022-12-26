/**
 * 1. 범위 내의 모든 구역이 같은 색인지 확인한다.
 * 1-1. 같은 색이라면 해당 색의 개수를 센다.
 * 1-2. 같은 색이 아니라면 9개의 구역으로 나눠서 1을 다시 진행한다.
 * 2. 각각의 색의 개수를 출력한다.
 */

package beakjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1780_종이의개수 {
    static int[] numOfPapers = { 0, 0, 0 };
    static int[][] rows = { {0, 1}, {1, 2}, {2, 3} };
    static int[][] cols = { {0, 1}, {1, 2}, {2, 3} };
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                paper[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }
        br.close();
        countColors(0, 0, N, N);
        for (int num : numOfPapers) {
            System.out.println(num);
        }
    }

    static void countColors(int top, int left, int bottom, int right) {
        if (top == bottom) {
            numOfPapers[paper[top][left]]++;
            return;
        }
        if (isSameColors(top, left, bottom, right)) {
            numOfPapers[paper[top][left]]++;
            return;
        }
        int length = (right - left) / 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                countColors(top + length * rows[i][0], left + (length * cols[j][0]),
                        top + (length * rows[i][1]), left + (length * cols[j][1]));
            }
        }
    }

    static boolean isSameColors(int top, int left, int bottom, int right) {
        int color = paper[top][left];
        for (int i = top; i < bottom; ++i) {
            for (int j = left; j < right; ++j) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
