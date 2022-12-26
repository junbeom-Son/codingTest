/**
 * I와 O로만 이루어진 문자열을 가지고 패턴을 가진 문자열이 몇개 나오는지 새는 프로그램
 * index 2 부터 n - 1까지의 문자들을 순회
 * 1. 현재 위치의 문자가 I라면
 * 2. 현재 위치 - 1의 문자가 O이고 현재 위치의 - 2의 문자가 I인지 확인한다.
 * 2-1. 조건을 충족한다면 현재위치 - 2의 위치의 카운트 + 1을 센다.
 * 3. 카운트를 저장한 배열을 순회하며 n 이상이 저장된 곳들의 숫자를 센 후 출력한다.
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String IOString = br.readLine();
        br.close();
        int[] patternCounts = new int[m];
        for (int i = 2; i < m; ++i) {
            if (IOString.charAt(i) == 'I' && IOString.charAt(i - 1) == 'O' && IOString.charAt(i - 2) == 'I') {
                patternCounts[i] = patternCounts[i - 2] + 1;
                ++i;
            }
        }
        int result = 0;
        for (int i = 2; i < m; ++i) {
            if (patternCounts[i] >= n) {
                ++result;
                ++i;
            }
        }
        System.out.println(result);
    }
}
