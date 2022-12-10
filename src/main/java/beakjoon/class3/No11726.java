package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= n; ++i) {
            ways[i] = (ways[i - 2] + ways[i - 1]) % 10007;
        }
        System.out.println(ways[n]);
    }
}
