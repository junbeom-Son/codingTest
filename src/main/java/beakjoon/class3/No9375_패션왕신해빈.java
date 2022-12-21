/**
 * 모든 옷들의 조합 수
 * 입력 : 테스트케이스 수 t, 의상의 수 n, n개의 의상의 이름과 의상의 종류
 * 출력 : 옷들의 조합 수
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; ++i) {
            Map<String, Integer> clothes = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                if (!clothes.containsKey(type)) {
                    clothes.put(type, 0);
                }
                clothes.put(type, clothes.get(type) + 1);
            }
            System.out.println(countCombinations(clothes));
        }
        br.close();
    }

    private static int countCombinations(Map<String, Integer> clothes) {
        int count = 0;
        for (int nums : clothes.values()) {
            count = count + (count * nums) + nums;
        }
        return count;
    }
}
