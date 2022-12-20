/**
 * 주지수
 * 입력 : 영토의 크기 N x M(1 <= N, M <= 1,024),
 *       N개의 줄에 M개의 정수로 단위 구역 내에 살고 있는 사람 수
 *       직사각형 범위의 개수 K
 *       K개의 줄에 네 개의 정수(직사각형 범위) x1, y1, x2, y2(x1 <= x2, y1 <= y2)
 * 출력 : K개의 줄에 순서대로 주어진 직사각형 범위 내에 살고 있는 사람 수의 합
 *
 * 입력을 받은 N개의 줄들을 각각의 행까지의 합을 구한다.
 * 범위를 입력받고 x1 ~ x2 사이의 줄들의 합을 구하는데,
 * 앞에서 초기화 했던 각행까지의 최대 합을 이용한다.
 * 각 줄별로 y2까지의 합에서 y1 이전의 합을 빼면 그 줄의 합이 된다.
 */
package beakjoon.christmasEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15724_주지수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] territory = new int[N + 1][M + 1];
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; ++j) {
                territory[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initializeTerritory(territory);
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            int top = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(sumOfPeopleInRange(territory, top, left, bottom, right));
        }
        br.close();
    }

    private static void initializeTerritory(int[][] territory) {
        for (int i = 1; i < territory.length; ++i) {
            for (int j = 2; j < territory[i].length; ++j) {
                territory[i][j] += territory[i][j - 1];
            }
        }
    }

    private static int sumOfPeopleInRange(int[][] territory, int top, int left, int bottom, int right) {
        int sum = 0;
        for (int i = top; i <= bottom; ++i) {
            sum += territory[i][right];
            if (left > 1) {
                sum -= territory[i][left - 1];
            }
        }
        return sum;
    }
}
