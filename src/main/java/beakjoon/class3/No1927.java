/**
 * 최소 힙
 * 입력 : 연산의 개수 N, N개의 연산에 대한 정보 x
 * 출력 : 입력에서 0이 주어진 횟수만큼 답 출력
 * 1. 입력 값이 0이 아닌 경우, priority queue에 정수 삽입
 * 2. 입력 값이 0인 경우
 * 2-1. priority queue가 비어있다 -> 0출력
 * 2-2. priority queue가 비어있지 않다 -> 가장 작은 값 출력
 */

package beakjoon.class3;

import java.io.*;
import java.util.PriorityQueue;

public class No1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] operations = new int[N];
        for (int i = 0; i < N; ++i) {
            operations[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; ++i) {
            if (operations[i] == 0) {
                if (pq.size() == 0) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.offer(operations[i]);
            }
        }
        bw.flush();
        bw.close();
    }
}
