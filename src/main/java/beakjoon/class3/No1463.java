/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을 때, 3가지 연산을 적절히 사용해서 1을 만들려고 한다. 연산 횟수 최소값 출력
 * 풀이 방식
 * 1. X가 3으로 나누어 떨어진다 -> X / 3 의 최소 횟수 + 1 = 횟수 1
 * 2. X가 2로 나누어 떨어진다 -> X / 2 의 최소 횟수 + 1 = 횟수 2
 * 3. 1을 뺀다 -> X - 1 의 최소 횟수 + 1 = 횟수 3
 * 1을 제외한 모든 수는 1을 빼는 것이 가능하고, 숫자에 따라 횟수 1, 2는 가능한지 여부를 판단해본다.
 * 3가지 중 가능한 횟수들 중 최소 값이 X를 1로 만드는 최소 연산 횟수이다.
 */

package beakjoon.class3;

import java.util.Scanner;

public class No1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[] nums = new int[N + 1];
        nums[1] = 0;
        for (int i = 2; i <= N; ++i) {
            int count1 = Integer.MAX_VALUE;
            int count2 = Integer.MAX_VALUE;
            int count3 = nums[i - 1] + 1;
            if (i % 3 == 0) {
                count1 = nums[i / 3] + 1;
            }
            if (i % 2 == 0) {
                count2 = nums[i / 2] + 1;
            }
            int min = count1;
            if (min > count2) {
                min = count2;
            }
            if (min > count3) {
                min = count3;
            }
            nums[i] = min;
        }
        System.out.println(nums[N]);
    }
}
