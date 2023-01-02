/**
 * 1. 모기의 입장시각 정렬
 * 2. 모기의 퇴장시각 정렬
 * 3. 임의의 모기A의 입장시각과 임의의 모기B의 퇴장시각이 같다면 다음 모기 대기
 * 4. 모기가 입장하면 모기 카운트 1 증가
 * 4-1. 모기가 입장할 때 이전 최대 모기 수보다 많다면 최대 모기수 및 당시 시각 기록
 * 5. 모기가 퇴장할때 현재 모기수가 최대 모기수 이고 최대 모기수 입장 시각을 기록하고 있다면
 * 5-1. 최대 모기수 퇴장 시각 기록
 * 5-2. 모기 카운트 1 감소
 * 6. 최대 모기수와 최대 모기수가 있는 시간대 출력
 */
package beakjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20440_니가싫어싫어너무싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int entryTimes[] = new int[n];
        int exitTimes[] = new int[n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            entryTimes[i] = Integer.parseInt(st.nextToken());
            exitTimes[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(entryTimes);
        Arrays.sort(exitTimes);
        int maxCount = 0;
        int count = 0;
        int maxTimeStart = 0;
        int maxTimeEnd = 0;
        int entryCount = 0;
        int exitCount = 0;
        boolean startTimeCount = false;
        while (entryCount < n) {
            if (exitTimes[exitCount] == entryTimes[entryCount]) {
                ++exitCount;
                ++entryCount;
            } else if (exitTimes[exitCount] < entryTimes[entryCount]) {
                if (count == maxCount && startTimeCount) {
                    startTimeCount = false;
                    maxTimeEnd = exitTimes[exitCount];
                }
                --count;
                ++exitCount;
            } else {
                ++count;
                if (count > maxCount) {
                    maxCount = count;
                    maxTimeStart = entryTimes[entryCount];
                    startTimeCount = true;
                }
                ++entryCount;
            }
        }
        if (startTimeCount) {
            maxTimeEnd = exitTimes[exitCount];
        }
        System.out.println(maxCount);
        System.out.println(maxTimeStart + " " + maxTimeEnd);
    }
}
