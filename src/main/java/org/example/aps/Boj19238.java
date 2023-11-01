package org.example.aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj19238 {
    private int size;
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        size = Integer.parseInt(infoToken.nextToken());
        int goalCount = Integer.parseInt(infoToken.nextToken());
        int fuel = Integer.parseInt(infoToken.nextToken());
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer rowToken = new StringTokenizer(reader.readLine());
            for (int j = 0; j < size; j++) {
                // 초기화 된 정수 배열은 전부 0, 1만 추가로 할당해 주기
                if (Integer.parseInt(rowToken.nextToken()) == 1) map[i][j] = 1;
            }
        }

        // 그 다음 첫줄 입력은 시작지점
        StringTokenizer startToken = new StringTokenizer(reader.readLine());
        int[] start = new int[]{
                // +1 되어있는 인덱스에서 -1 해준다.
                Integer.parseInt(startToken.nextToken()) - 1,
                Integer.parseInt(startToken.nextToken()) - 1
        };

        // 승객 정보 저장용 배열 두개 (픽업, 목적지)
        int[][] customers = new int[goalCount][];
        int[][] goals = new int[goalCount][];

        for (int i = 0; i < goalCount; i++) {
            StringTokenizer customerToken = new StringTokenizer(reader.readLine());
            customers[i] = new int[]{
                    Integer.parseInt(customerToken.nextToken()) - 1,
                    Integer.parseInt(customerToken.nextToken()) - 1
            };
            goals[i] = new int[]{
                    Integer.parseInt(customerToken.nextToken()) - 1,
                    Integer.parseInt(customerToken.nextToken()) - 1
            };
        }

        // 승객을 잘 보내줬는지
        boolean[] done = new boolean[goalCount];
        // 델타 탐색용
        int[][] deltas = new int[][]{
                new int[]{-1, 0},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{0, 1},
        };

        while (!finished(done)) {
            // while 내부에서 방문 여부 배열을 초기화해준다.
            // 승객을 무사히 보내드렸으면 이미 왔던 길을 다시 갈 수도 있기 때문
            boolean[][] visited = new boolean[size][size];
            visited[start[0]][start[1]] = true;
            Queue<int[]> toVisit = new LinkedList<>();
            // 승객까지의 최단거리도 기억을 해야한다.
            toVisit.add(new int[]{start[0], start[1], 0});
            // 승객을 만난적 있는지
            // 이때 승객을 한번 만났다고 BFS 중단하지 않는다.
            // 대신 현재 Queue에 남아있는 지점들만 방문한다.
            // 같은 거리의 다른 승객이 있을 수 있기 때문
            boolean meetCustomer = false;
            int nearCustomerIdx = -1;
            int nearCustomerDist = 0;
            // 승객한테 간다.
            while (!toVisit.isEmpty()) {
                int[] now = toVisit.poll();
                // TODO 1. 현재 위치에 승객이 있는지 판단한다.
                // TODO 2. 이번에 만난 승객의 유무에 따라
                // TODO 2-1. 만난 적 없으면 meetCustomer 등의 정보 갱신
                // TODO 2-2. 만난 적 있으면 이미 저장된 정보와 해당 새로운 승객의 정보를 비교 후 업데이트
                // TODO 3-1. 만약 승객을 아직 못 만났다면 다시 델타 검색 시작
                // TODO 3-2. 승객을 만났다면 델타 검색 중단 (Queue 업데이트 중단)
            }
        }

        return -1;
    }

    private boolean finished(boolean[] doneList) {
        for (boolean done : doneList) {
            if (!done) return false;
        }
        return true;
    }
}