/**
 * 수빈이의 동생 찾기
 * 입력 : 수빈이의 위치 N, 동생의 위치 K
 * 출력 : 동생을 찾는데 걸리는 최소 시간
 * 점화식을 사용해 K까지 도달하는데 시간을 구한다.
 * i까지 도달하는데의 최소 시간 3가지
 * 1. i - 1까지 가는데 걸리는 최소시간 + 1
 * 2. i / 2까지 가는데 걸리는 최소시간 + 1 (짝수인 경우)
 * 3. i + 1까지 가는데 걸리는 최소시간 + 1
 * 셋중에 가장 적은 것을 선택한다.
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1697_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            System.out.println(N - K);
        } else {
            int[] times = new int[K + 2];
            for (int i = N; i >= 0; --i) {
                times[i] = N - i;
            }
            for (int i = N + 1; i <= K + 1; ++i) {
                times[i] = times[i - 1] + 1;
                if (i % 2 == 0) {
                    times[i] = Math.min(times[i], times[i / 2] + 1);
                    if (times[i] + 1 < times[i - 1]) {
                        times[i - 1] = times[i] + 1;
                    }
                }
            }
            System.out.println(times[K]);
        }
    }
}
