/**
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 찾기
 * 입력 : 컴퓨터의 수, 연결된 컴퓨터 쌍의 수, 연결된 컴퓨터의 번호 쌍
 * 출력 : 1번 컴퓨터가 바이러스에 걸렸을 때 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터 수
 * 각각의 쌍을 입력 받고, 연결된 컴퓨터 두개를 자신의 대표 컴퓨터를 비교해서
 * 숫자가 더 낮은 대표 컴퓨터로 합병한다.
 * 1번을 대표 컴퓨터로 갖는 컴퓨터의 수를 출력한다.
 */

package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] computers = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            computers[i] = i;
        }
        int numOfLines = Integer.parseInt(br.readLine());
        String[][] lines = new String[numOfLines][2];
        for (int i = 0; i < numOfLines; ++i) {
            lines[i] = br.readLine().split(" ");
        }
        br.close();
        for (int i = 0; i < numOfLines; ++i) {
            int computer1 = find(computers, Integer.parseInt(lines[i][0]));
            int computer2 = find(computers, Integer.parseInt(lines[i][1]));
            merge(computers, computer1, computer2);
        }
        int infected = 0;
        for (int i = 2; i <= N; ++i) {
            if (find(computers, i) == 1) {
                infected++;
            }
        }
        System.out.println(infected);
    }

    static int find(int[] computers, int n) {
        if (n != computers[n]) {
            computers[n] = find(computers, computers[n]);
        }
        return computers[n];
    }

    static void merge(int[] computers, int n1, int n2) {
        if (computers[n1] < computers[n2]) {
            computers[n2] = computers[n1];
        } else if (computers[n1] > computers[n2]) {
            computers[n1] = computers[n2];
        }
    }
}
