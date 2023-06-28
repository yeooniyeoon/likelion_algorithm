package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 방문했는지를 파악해야 한다.
        boolean[] visited = new boolean[n];
        // 모든 컴퓨터(정점)를 순회합니다.
        for (int i = 0; i < n; i++) {
            // 이 컴퓨터가 속한 네트워클르 확인한 적 없다면
            // 이 컴퓨터를 방문한 적 없다고 나올 것이다.
            if (!visited[i]) {
                // DFS 또는 BFS
                answer++;
            }
        }

        return answer;
    }

    public void network(
            // 몇 번 컴퓨터부터 확인 예정인지
            int computer,
            // 컴퓨터 개수
            int n,
            // 컴퓨터 연결 정보
            int[][] computers,
            // 컴퓨터 방문 정보
            boolean[] visited
    ) {
        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.offer(computer);
        while (!toVisit.isEmpty()) {
            int next = toVisit.poll();

            for (int i = 0; i < n; i++) {
                // computers[next][i] == 1 : 연결되어 있음
                // !visited[i] : 방문한 적 없음
                if (computers[next][i] == 1 && !visited[i]) {
                    toVisit.offer(i);
                    visited[i] = true;
                }

            }
        }
    }


    public static void main(String[] args) {
        int answer = new Programmers43162().solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        });
        System.out.println(answer);
    }
}
