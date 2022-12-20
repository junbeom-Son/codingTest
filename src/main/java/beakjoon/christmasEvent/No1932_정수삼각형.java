/**
 * 정수 삼각형
 * 맨 위층부터 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
 * 선택된 수의 합이 최대가 되는 경로를 구하는 문제
 * 입력 : 삼각형의 크기 n(1 <= n <= 500), n 줄의 정수 삼각형 입력
 * 출력 : 합이 최대가 되는 경로의 수의 합
 * 밑에서 두번째 줄부터 위로 거꾸로 공략
 * 1. 현재 수를 아래의 두 수중 더 큰 수를 선택하여 합함
 * 2. 맨 위층까지 1.을 반복
 */

package beakjoon.christmasEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) { // 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; ++j) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        System.out.println(triangle[1][1]);
    }
}
