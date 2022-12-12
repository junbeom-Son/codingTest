/**
 * 좌표 압축
 * 입력 : 좌표 개수 N, N개의 좌표 X1, X2, ..., XN
 * 출력 : 압축된 N개의 좌표 X'1, X'2, ..., X'N
 * 1. N개의 좌표 저장
 * 2. 자동 정렬되고 중복 저장 하지않는 TreeSet 좌표값들 저장
 * 3. N개의 좌표를 해당 좌표값 보다 작은 숫자의 개수로 변경 후 출력
 */

package beakjoon.class3;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coordinates = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            coordinates[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Set<Integer> coordinateSet = new TreeSet<>();
        for (int i = 0; i < N; ++i) {
            coordinateSet.add(coordinates[i]);
        }
        Integer[] uniqueCoordinates = coordinateSet.toArray(new Integer[0]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; ++i) {
            bw.write(Arrays.binarySearch(uniqueCoordinates, coordinates[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
