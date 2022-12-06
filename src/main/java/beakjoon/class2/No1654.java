/**
 * K개의 랜선으로 N개의 같은 길이의 랜선으로 만들기
 * 입력 : 소유하고 있는 랜선의 수 K, 필요한 랜선의 수 N, K개의 소유하고 있는 랜선 각각의 길이
 * 출력 : N개 이상을 만들 수 있는 가장 랜선의 길이
 * 가능한 랜선의 최대 길이(possibleMaxLen)를 0으로 초기화 한다.(아직 가능한 랜선의 최대 길이를 모르기 때문)
 * 기준길이(stdLen)를 가지고 있는 랜선중 가장 작은 값으로 설정한다.
 * 1. 기준길이가 최대길이보다 짧거나 같을때까지 반복한다. (기준길이가 만들 수 있는 최대길이보다 길다면 계속해서 반복한다.)
 * 1-1. 기준길이로 잘라서 만들 수 있는 랜선의 수(count)를 계산한다.
 * 1-2. 기준길이로 만들 수 있는 랜선의 수(count)와 필요한 랜선의 수(N)을 비교한다.
 * 1-2-1. count >= N (만들 수 있는 랜선의 수가 필요한 수 보다 더 많은 경우) -> 기준길이를 늘린다.
 * 1-2-2. count < N (만들 수 있는 랜선의 수가 필요한 수 보다 더 적은 경우) -> 기준길이를 줄인다.
 * 2. 만들 수 있는 랜선의 최대 길이를 출력한다.
 */

package beakjoon.class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 오영식이 이미 가지고 있는 랜선의 개수
        int N = sc.nextInt(); // 필요한 랜선의 개수
        List<Integer> lines = new ArrayList<>(); // 가지고 있는 K개의 랜선들
        for (int i = 0; i < K; ++i) {
            lines.add(sc.nextInt());
        }
        int possibleMaxLen = 0; // 가능한 랜선의 최대 길이
        int impossibleMinLen = getMax(lines); // 불가능한 랜선의 최소 길이
        int stdLen = getMin(lines);
        while (stdLen > possibleMaxLen) {
            int count = getCount(lines, stdLen);
            if (count >= N) {
                possibleMaxLen = stdLen;
                stdLen = (possibleMaxLen + impossibleMinLen) / 2;
            } else {
                impossibleMinLen = stdLen;
                stdLen = (possibleMaxLen + stdLen) / 2;
            }
        }
        System.out.println(possibleMaxLen);
        sc.close();
    }

    static private int getMax(List<Integer> lines) {
        int max = -1;
        for (int line : lines) {
            if (max < line) {
                max = line;
            }
        }
        return max;
    }

    static private int getMin(List<Integer> lines) {
        int min = Integer.MAX_VALUE;
        for (int line : lines) {
            if (min > line) {
                min = line;
            }
        }
        return min;
    }

    static private int getCount(List<Integer> lines, int stdLen) {
        int count = 0;
        for (Integer line : lines) {
            count += line / stdLen;
        }
        return count;
    }
}
