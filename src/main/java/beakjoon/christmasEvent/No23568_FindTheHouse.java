package beakjoon.christmasEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No23568_FindTheHouse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Position> positions = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            int distance = Integer.parseInt(st.nextToken());
            positions.put(position, new Position(direction, distance));
        }
        int currentPosition = Integer.parseInt(br.readLine());
        System.out.println(findHouse(positions, currentPosition));
    }

    private static int findHouse(Map<Integer, Position> positions, int currentPosition) {
        while (!positions.isEmpty()) {
            Position position = positions.get(currentPosition);
            positions.remove(currentPosition);
            if (position.direction == 'L') {
                currentPosition -= position.distance;
            } else {
                currentPosition += position.distance;
            }
        }
        return currentPosition;
    }
}

class Position {
    char direction;
    int distance;

    public Position(char direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
}
