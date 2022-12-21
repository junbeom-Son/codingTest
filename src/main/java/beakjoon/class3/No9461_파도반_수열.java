/**
 * 파도반 수열 P(N) 구하기
 * 입력 : 테스트 케이스의 수 T, 각 테스트별 N
 * 출력 : 각 테스트별 P(N) 구하기
 * P(1) ~ P(5) 까지는 순서대로 1, 1, 1, 2, 2 이며
 * P(6) 부터는 P(i - 1) + p(i - 4)의 패턴을 가진다.
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9461_파도반_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] inputs = new int[T];
        int max = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; ++i) {
            inputs[i] = Integer.parseInt(br.readLine());
            if (inputs[i] > max) {
                max = inputs[i];
            }
        }
        long[] PNLengths = initializeLengths(max);
        for (int i = 0; i < T; ++i) {
            answer.append(PNLengths[inputs[i]]).append("\n");
        }
        System.out.println(answer);
        br.close();
    }

    public static long[] initializeLengths(int max) {
        long[] PNLengths = new long[max + 1];
        PNLengths[1] = 1;
        PNLengths[2] = 1;
        PNLengths[3] = 1;
        PNLengths[4] = 2;
        PNLengths[5] = 2;
        for (int i = 6; i <= max; ++i) {
            PNLengths[i] = PNLengths[i - 1] + PNLengths[i - 5];
        }
        return PNLengths;
    }
}
