package org.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSerarch {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxNodes = Integer.parseInt(reader.readLine());
        // 인접 정보 저장용
        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];

        /*
        입력 예제
        7
        1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 6 7

         */

        String[] edges = reader.readLine().split(" ");
        for (int i = 0; i < edges.length / 2; i++) {
            int leftNode = Integer.parseInt(edges[i * 2]);
            int rightNode = Integer.parseInt(edges[i * 2 + 1]);
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        // BFS
        // 다음 방문 대상 기록용 Queue

        Queue<Integer> toVisit = new LinkedList<>();
        // 방문 순서 기록용
        List<Integer> visitedOrder = new ArrayList<>();
        //방문 기록용 boolean()
        boolean[] visited = new boolean[maxNodes + 1];

        int next = 1;
        toVisit.offer(next);
        // 큐가 비어있지 않은 동안 반복
        while (!toVisit.isEmpty()) {
            // 다음 방문 정점 회수
            next = toVisit.poll();

            // 이미 방문 했다면 다음 반복으로
            if (visited[next]) continue;

            // 방문했다 표시
            visited[next] = true;
            // 방문한 순서 기록
            visitedOrder.add(next);

            // 다음 방문 대상을 검색한다.
            for (int i = 0; i < maxNodes + 1; i++) {
                // adjMap[next]가 담고 있는 배열은
                // idx번째가 1인 경우 idx에 연결되어 있다는 의미
                if (adjMap[next][i] == 1 && !visited[i])
                    toVisit.offer(i);
            }
        }

        // 출력
        System.out.println(visitedOrder);
    }

    public static void main(String[] args) throws IOException {
        new BreadthFirstSerarch().solution();
    }
}
