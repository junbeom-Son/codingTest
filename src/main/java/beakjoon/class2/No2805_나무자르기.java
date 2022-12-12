/**
 * N개의 나무를 잘라 M 미터의 나무 재료 얻기
 * 입력 : 나무의 수 N, 필요한 나무 길이 M, N개 나무 각각의 길이
 * 출력 : 절단기의 최대 높이
 * 높이가 낮을 수록, 나무를 많이 자르게 된다. 즉 절단기의 최대 높이를 구하는 것은, 나무를 최소한으로 자른다는 의미
 * 기준 높이(stdHeight)를 가장 키가 작은 나무의 길이로 초기화 한다.
 * 가능한 최대 높이(possibleMaxHeight)를 -1으로 초기화 한다.
 * 불가능한 최대 높이(impossibleMinHeight)를 가장 키가 큰 나무의 길이로 초기화 한다.
 * 1. 기준 높이가 최대 높이보다 낮거나 같아질 때까지 반복한다.
 * 1-1. 기준 높이로 자를수 있는 나무의 길이(length)를 계산한다.
 * 1-2. 자른 길이와 필요한 길이를 비교한다.
 * 1-2-1. 필요한 길이보다 더 많이 잘랐다 -> 높이를 더 높인다.
 * 1-2-2. 필요한 길이보다 덜 잘랐다 -> 높이를 더 낮춘다.
 * 2. 필요한 만큼의 나무를 자를 수 있는 최대 높이를 출력한다.
 */

package beakjoon.class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No2805_나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        List<Long> trees = new ArrayList<>();
        for (long i = 0; i < N; ++i) {
            trees.add(sc.nextLong());
        }
        sc.close();
        long stdHeight = getShortestTree(trees);
        long possibleMaxHeight = -1;
        long impossibleMinHeight = getTallestTree(trees);
        while (stdHeight > possibleMaxHeight) {
            long possibleLength = calculatePossibleLength(trees, stdHeight);
            if (M <= possibleLength) {
                possibleMaxHeight = stdHeight;
                stdHeight = (stdHeight + impossibleMinHeight) / 2;
            } else {
                impossibleMinHeight = stdHeight;
                stdHeight = (stdHeight + possibleMaxHeight) / 2;
            }
        }
        System.out.println((int)possibleMaxHeight);
    }

    private static long getShortestTree(List<Long> trees) {
        long shortestTree = Integer.MAX_VALUE;
        for (long tree : trees) {
            if (shortestTree > tree) {
                shortestTree = tree;
            }
        }
        return shortestTree;
    }

    private static long getTallestTree(List<Long> trees) {
        long tallestTree = 0;
        for (long tree : trees) {
            if (tallestTree < tree) {
                tallestTree = tree;
            }
        }
        return tallestTree;
    }

    private static long calculatePossibleLength(List<Long> trees, long stdHeight) {
        long possibleLength = 0;
        for (long tree : trees) {
            if (tree > stdHeight) {
                possibleLength += tree - stdHeight;
            }
        }
        return possibleLength;
    }
}
