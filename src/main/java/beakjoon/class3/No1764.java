/**
 * 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구한다.
 * 입력 : 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M, N명의 듣도 못한사람의 이름, M명의 보도 못한 사람의 이름
 * 출력 : 듣도 보도 못한 사람들의 이름 사전순
 * 듣도 못한 사람과 보도 못한 사람의 명단에서 겹치는 인원들을 추출한다.
 */


package beakjoon.class3;

import java.io.*;
import java.util.*;

public class No1764 {
    public static void main(String[] args) throws IOException {
        System.out.println("시작");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] numbers = br.readLine().split(" ");
        int N = Integer.parseInt(numbers[0]);
        int M = Integer.parseInt(numbers[1]);
        Set<String> neverHeard = new HashSet<>();
        List<String> neverHeardNeverSeen = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            neverHeard.add(br.readLine());
        }
        for (int i = 0; i < M; ++i) {
            String neverSeen = br.readLine();
            if (neverHeard.contains(neverSeen)) {
                neverHeardNeverSeen.add(neverSeen);
            }
        }
        Collections.sort(neverHeardNeverSeen);
        bw.write(neverHeardNeverSeen.size() + "\n");
        for (String name : neverHeardNeverSeen) {
            bw.write(name + "\n");
        }
        bw.flush();
    }
}
