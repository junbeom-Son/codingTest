/**
 * Z 순서
 * 입력 : N(1 <= N <= 15), 행 r, 열 c
 * 출력 : 2^N x 2^N 행렬의 r행 c열을 Z순서대로 방문하면 몇번째로 방문했는지 출력
 * 1. 사용할 기준 길이를 행렬의 길이인 2^N으로 초기화
 * 2. 범위 내의 첫번째 칸(젤 왼쪽 젤 위)에 있는 값 저장
 * 3. 순서를 정할때는 왼쪽위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순으로 지나가기 때문에
 *    찾아야 할 위치가 어디에 있는지 검사
 * 3-1. 왼쪽 위 : 첫번째 칸 + ((현재 사용하고 있는 길이 / 2)^2 * 0)
 * 3-2. 오른쪽 위 : 첫번째 칸 + ((현재 사용하고 있는 길이 / 2)^2 * 1)
 * 3-3. 왼쪽 아래 : 첫번째 칸 + ((현재 사용하고 있는 길이 / 2)^2 * 2)
 * 3-4. 오른쪽 아래 : 첫번째 칸 + ((현재 사용하고 있는 길이 / 2)^2 * 3)
 * 4. r행 c열에 도달할 때까지 반복
 */
package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1074_Z {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();
        int length = (int)Math.pow(2, N);
        System.out.println(findVisitOrder(length, r, c));
    }

    private static int findVisitOrder(int length, int r, int c) {
        int left = 0;
        int right = length;
        int top = 0;
        int bottom = length;
        int first = 0;
        while (true) {
            if (top == r && left == c) {
                break;
            }
            int unit = getUnit(length);
            if (isOnTopSide(top, bottom, r)) {
                if (isOnLeftSide(left, right, c)) {
                    right = (left + right) / 2;
                } else {
                    first = first + unit;
                    left = (left + right) / 2;
                }
                bottom = (top + bottom) / 2;
            } else {
                if (isOnLeftSide(left, right, c)) {
                    first = first + unit * 2;
                    right = (left + right) / 2;
                } else {
                    first = first + unit * 3;
                    left = (left + right) / 2;
                }
                top = (top + bottom) / 2;
            }
            length /= 2;
        }
        return first;
    }

    static private int getUnit(int length) {
        length /= 2;
        return length * length;
    }

    static private boolean isOnTopSide(int top, int bottom, int r) {
        if (r < (top + bottom) / 2) {
            return true;
        }
        return false;
    }

    static private boolean isOnLeftSide(int left, int right, int c) {
        if (c < (left + right) / 2) {
            return true;
        }
        return false;
    }
}
