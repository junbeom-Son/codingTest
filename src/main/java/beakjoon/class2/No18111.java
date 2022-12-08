/**
 * 입력 : 행 수 N, 열 수 M, 잉여 블록 B, N X M 크기의 맵 각 블록의 높이
 * 출력 : N X M 크기의 맵을 평평하게 만드는데 걸리는 최소시간 및 높이
 * 가장 낮은 높이와 가장 높은 높이를 구한다.
 * 가장 높은 높이부터 가장 낮은 높이까지 땅을 다 다져본다.
 * 이중 시간이 제일 적게드는 시간이 드는 층을 선택하고, 만약 여러개라면 그중 최고 높이 선택
 */

package beakjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18111 {
    static final int MAX_HEIGHT = 256;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] land = new int[MAX_HEIGHT + 1];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                land[Integer.parseInt(st.nextToken())]++;
            }
        }
        br.close();
        int[] shortestTimeAndHeight = getShortestTimeAndHeight(land, B);
        System.out.println(shortestTimeAndHeight[0] + " " + shortestTimeAndHeight[1]);
    }

    private static int[] getShortestTimeAndHeight(int[] land, int extraBlock) {
        int[] lowestAndHighestHeights = getLowestAndHighestHeights(land);
        int lowestHeight = lowestAndHighestHeights[0];
        int highestHeight = lowestAndHighestHeights[1];
        int shortestTime = Integer.MAX_VALUE;
        int height = -1;
        for (int i = highestHeight; i >= lowestHeight; --i) {
            int flattenTime = calculateTime(land, i, extraBlock);
            if (flattenTime == -1) {
                continue;
            }
            if (shortestTime > flattenTime) {
                shortestTime = flattenTime;
                height = i;
            } else {
                break;
            }
        }
        return new int[]{shortestTime, height};
    }

    private static int[] getLowestAndHighestHeights(int[] land) {
        int lowestHeight = Integer.MAX_VALUE;
        int highestHeight = -1;
        for (int i = 0; i <= MAX_HEIGHT; ++i) {
            if (land[i] > 0) {
                if (lowestHeight > i) {
                    lowestHeight = i;
                }
                if (highestHeight < i) {
                    highestHeight = i;
                }
            }
        }
        return new int[]{lowestHeight, highestHeight};
    }

    private static int calculateTime(int[] land, int stdHeight, int extraBlock) {
        int digLandCount = 0;
        int coverLandCount = 0;
        for (int i = 0; i <= MAX_HEIGHT; ++i) {
            if (land[i] > 0) {
                if (i > stdHeight) {
                    digLandCount += (i - stdHeight) * land[i];
                } else if (i < stdHeight) {
                    coverLandCount += (stdHeight - i) * land[i];
                }
            }
        }
        extraBlock += digLandCount;
        if (coverLandCount > extraBlock) {
            return -1;
        }
        return coverLandCount + digLandCount * 2;
    }
}
