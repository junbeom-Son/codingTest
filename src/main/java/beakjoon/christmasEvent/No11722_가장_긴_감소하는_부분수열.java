package beakjoon.christmasEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11722_가장_긴_감소하는_부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(getMaxLength(numbers, N));
    }

    private static int getMaxLength(int[] numbers, int N) {
        int[] lengths = new int[N];
        lengths[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < N; ++i) {
            if (numbers[i] == numbers[i - 1]) {
                lengths[i] = lengths[i - 1];
            } else {
                lengths[i] = findLength(numbers, lengths, i);
                if (lengths[i] > maxLength) {
                    maxLength = lengths[i];
                }
            }
        }
        return maxLength;
    }

    private static int findLength(int[] numbers, int[] lengths, int i) {
        int maxLength = 0;
        for (int j = i - 1; j >= 0; --j) {
            if (numbers[i] >= numbers[j]) {
                continue;
            } else {
                if (lengths[j] > maxLength) {
                    maxLength = lengths[j];
                }
            }
        }
        return maxLength + 1;
    }
}
