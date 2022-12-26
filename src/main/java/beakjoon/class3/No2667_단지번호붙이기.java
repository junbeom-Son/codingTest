/**
 * 연결된 각 단지를 찾고, 단지 별 집의 수를 오름차순으로 정렬 후 한줄 씩 출력
 * 1. N x N 크기의 단지 내의 집들을 하나씩 순회한다.
 * 2. 집이 있는 곳을 발견하면 연결된 집이 있는지 확인한다.
 * 3. 중복 계산을 방지하기 위해 계산을 위해 방문한 적이 있는지 확인한다.
 * 4. 연결된 집이 있고, 방문한 적이 없다면 해당 단지의 집 개수를 하나 센다.
 * 5. 각 단지별 집의 수를 작은 수 부터 오름차순으로 출력한다.
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No2667_단지번호붙이기 {
    static int N;
    static boolean[][] visited;
    static String[] town;
    static List<Integer> complexes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        town = new String[N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            town[i] = br.readLine();
        }
        findComplexes();
        complexes.sort(Comparator.naturalOrder());
        System.out.println(complexes.size());
        for (int count : complexes) {
            System.out.println(count);
        }
    }

    static void findComplexes() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (town[i].charAt(j) == '1' && !visited[i][j]) {
                    complexes.add(countConnectedHouses(i, j, 0));
                }
            }
        }
    }

    static int countConnectedHouses(int row, int col, int count) {
        if (town[row].charAt(col) == '0' || visited[row][col]) {
            return count;
        }
        visited[row][col] = true;
        count++;
        if (row > 0) {
            count = countConnectedHouses(row - 1, col, count);
        }
        if (row < N - 1) {
            count = countConnectedHouses(row + 1, col, count);
        }
        if (col > 0) {
            count = countConnectedHouses(row, col - 1, count);
        }
        if (col < N - 1) {
            count = countConnectedHouses(row, col + 1, count);
        }
        return count;
    }
}
