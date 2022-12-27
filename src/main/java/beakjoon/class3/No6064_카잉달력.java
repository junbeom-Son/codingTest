/**
 * 1. yPrime을 첫 x값을 기준으로 설정한다.
 * 2. yPrime이 N과 일치하거나, 혹은 M * N크기의 순서가 올때까지 반복한다.
 *   2-1. yPrime을 M크기 만큼 더한 후의 값을 구한다.
 *   2-2. 순서를 M 만큼 증가시킨다.
 * 3. 순서가 M * N 이하이면 순서를 출력하고, 이상이면 -1을 출력한다.
 */

package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6064_카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            result.append(getYear(M, N, x, y)).append("\n");
            --T;
        }
        System.out.println(result);
        br.close();
    }

    static int getYear(int M, int N, int x, int y) {
        int yPrime = calculateYPrime(N, x);
        int year = x;
        int maxYear = getMaxYear(M, N);
        while (year < maxYear && yPrime != y) {
            yPrime = calculateYPrime(N, yPrime + M);
            year += M;
        }
        if (yPrime != y) {
            year = -1;
        }
        return year;
    }

    static int calculateYPrime(int N, int yPrime) {
        yPrime = yPrime % N;
        if (yPrime == 0) {
            yPrime = N;
        }
        return yPrime;
    }

    static int getMaxYear(int M, int N) {
        int greaterNum = Math.max(M, N);
        int lessNum = Math.min(M, N);
        int result = greaterNum;
        while (result % lessNum != 0) {
            result += greaterNum;
        }
        return result;
    }
}
