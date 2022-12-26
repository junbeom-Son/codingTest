/**
 * 1. 범위 내의 구역이 모두 같은 숫자인지 검사
 * 2. 범위 내의 구역이 모두 같지 않다면 '('을 출력하고 구역을 4개로 분할하여 1.을 다시 진행한다.
 * 진행 후에는 ')'을 출력한다.
 */

package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1992_쿼드트리 {
    static String[] video;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new String[N];
        for (int i = 0; i < N; ++i) {
            video[i] = br.readLine();
        }
        br.close();
        pressVideo(0, 0, N, N);
        System.out.println(result);
    }

    static void pressVideo(int top, int left, int bottom, int right) {
        if (isPressed(top, left, bottom, right)) {
            result.append(video[top].charAt(left));
            return;
        }
        result.append("(");
        pressVideo(top, left, (top + bottom) / 2, (left + right) / 2);
        pressVideo(top, (left + right) / 2, (top + bottom) / 2, right);
        pressVideo((top + bottom) / 2, left, bottom, (left + right) / 2);
        pressVideo((top + bottom) / 2, (left + right) / 2, bottom, right);
        result.append(")");
    }

    static boolean isPressed(int top, int left, int bottom, int right) {
        if (top == bottom) {
            return true;
        }
        char color = video[top].charAt(left);
        for (int i = top; i < bottom; ++i) {
            for (int j = left; j < right; ++j) {
                if (color != video[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
