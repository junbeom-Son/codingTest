/**
 * 2xn 타일링 2
 * 입력 : n
 * 출력 : 2xn 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
 * n = 1 : f(n) = 1이고
 * n이 짝수 : f(n - 1) * 2 + 1
 * n이 홀수 : f(n - 1) * 2 - 1
 */

package beakjoon.class3;

import java.util.Scanner;

public class No11727_2xn타일링2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        long answer = 1;
        for (int i = 2; i <= n; ++i) {
            answer *= 2;
            if (i % 2 == 0) {
                answer++;
            } else {
                answer--;
            }
            answer %= 10007;
        }
        System.out.println(answer);
    }
}
