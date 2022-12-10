/**
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하기
 * 입력 : 테스트 케이스의 수 T, 테스트 별 숫자 n(n < 10)
 * 출력 : 테스트 별 n을 1, 2, 3의 합으로 나타내는 방법의 수
 * 1: 1가지, 2: 2가지, 3: 3가지
 * n >= 4 -> n = (n - 1)방법 의 수 + (n - 2)방법 의 수 + (n - 3) 방법의 수
 */

package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ways = new int[11];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;
        for (int i = 4; i <= 10; ++i) {
            ways[i] = ways[i - 3] + ways[i - 2] + ways[i - 1];
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(ways[n]);
        }
        br.close();
    }
}
