/**
 * 이중 우선순위 큐 생성
 * 입력 : 테스트 케이스 T, 연산의 개수 k, k개의 연산 식
 * 1. I + 숫자 : tree map에 값 추가
 * 2. D + 숫자 : tree map에서 값 삭제
 * map의 크기가 0이라면 삭제연산 무시
 * 최소값을 삭제할 때에는, map.firstKey()를 사용해 최소 값을 찾고
 * 최대값을 삭제할 때에는, map.lastKey()를 사용해 최대 값을 찾는다.
 * 값을 삭제할때 공통적인 부분은, 같은 값이 하나만 있다면 key를 삭제하고
 * 두개 이상이 있다면 value를 1 감소 시킨다.
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No7662_이중_우선순위_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int j = 0; j < k; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char operation = st.nextToken().charAt(0);
                int number = Integer.parseInt(st.nextToken());
                if (operation == 'I') {
                    treeMap.merge(number, 1, Integer::sum);
                } else {
                    if (treeMap.isEmpty()) {
                        continue;
                    }
                    int key = treeMap.firstKey();
                    if (number == 1) { // 최대값
                        key = treeMap.lastKey();
                    }
                    int count = treeMap.get(key);
                    if (count == 1) {
                        treeMap.remove(key);
                    } else {
                        treeMap.put(key, count - 1);
                    }
                }
            }
            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
        br.close();
    }
}
