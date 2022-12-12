/**
 * 색종이 만들기
 * 입력 : 정사각형 가로 세로 길이 N(n = 2^k, k는 1 이상 7 이하의 자연수),
 *       색칠된 정사각형(0, 1로 표시)
 * 출력 : 잘라진 하얀색 색종이 개수, 파란색 색종이 개수
 * 1. 주어진 범위가 모두 같은색으로 칠해져 있는지 검사한다.
 * 2. 모두 같은색으로 칠해져 있다면 결과에 해당색의 개수를 한개 추가한다.
 * 3. 모두 같은색으로 칠해져 있지 않다면, 색종이를 4등분하여 각 부분을 1번부터 다시 수행한다.
 * 4. 하얀색과 파란색 색종이의 개수를 출력한다.
 */

package beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2630_색종이만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        int[] colors = new int[2]; // colors[0] = white, colors[1] = blue;
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getColorNumbers(paper, colors, 0, N, 0, N);
        System.out.println(colors[0]);
        System.out.println(colors[1]);
    }

    private static void getColorNumbers(int[][] paper, int[] colors, int left, int right, int top, int bottom) {
        if (isSameColor(paper, left, right, top, bottom)) {
            colors[paper[top][left]]++;
        } else {
            getColorNumbers(paper, colors, left, (left + right) / 2, top, (top + bottom) / 2);
            getColorNumbers(paper, colors, (left + right) / 2, right, top, (top + bottom) / 2);
            getColorNumbers(paper, colors, left, (left + right) / 2, (top + bottom) / 2, bottom);
            getColorNumbers(paper, colors, (left + right) / 2, right, (top + bottom) / 2, bottom);
        }
    }

    private static boolean isSameColor(int[][] paper, int left, int right, int top, int bottom) {
        int color = paper[top][left];
        for (int i = top; i < bottom; ++i) {
            for (int j = left; j < right; ++j) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
