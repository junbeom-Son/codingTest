package beakjoon.christmasEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1057_토너먼트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int numberOfParticipants = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansoo = Integer.parseInt(st.nextToken());
        System.out.println(findMatchRound(jimin, hansoo));
    }

    private static int findMatchRound(int jimin, int hansoo) {
        int round = 1;
        while (!isEncountered(jimin, hansoo)) {
            if (jimin % 2 == 1) {
                jimin++;
            }
            if (hansoo % 2 == 1) {
                hansoo++;
            }
            jimin /= 2;
            hansoo /= 2;
            round++;
        }
        return round;
    }

    private static boolean isEncountered(int jimin, int hansoo) {
        if (jimin % 2 == 1) {
            jimin++;
        }
        if (hansoo % 2 == 1) {
            hansoo++;
        }
        if (jimin == hansoo) {
            return true;
        }
        return false;
    }
}
