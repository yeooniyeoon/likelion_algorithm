package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RecursiveDFS {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer : 입력을 띄어쓰기 기준으로 여러개를 받음.
        // 입력받은 문자열을 띄어쓰기 (또는 지정된 delimiter) 나누어서 한 단어씩 반환해주는 도구
        StringTokenizer graphTokenizer // 8 10
                = new StringTokenizer(reader.readLine());
        // StringTokenizer.nextToken() : 다음 단어를 가져오기
        int maxNodes = Integer.parseInt(graphTokenizer.nextToken());    // 8
        int edges = Integer.parseInt(graphTokenizer.nextToken());       // 10

        // 안쪽의 List<Integer>가 maxNodes의 길이를 반드시 가지지는 않을 것이다.
        List<List<Integer>> adjList = new ArrayList<>();
        // 먼저 리스트의 내용물을 초기화 해준다.
        for (int i = 0; i < maxNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선의 갯수만큼 반복해서 입력을 받는다.
        int[][] adjMatrix = new int[maxNodes][maxNodes];
        for (int i = 0; i < edges; i++) {
            // 다음줄을 단어 단위로 나눠주는 Tokenizer
            StringTokenizer edgeTokenizer
                    = new StringTokenizer(reader.readLine());
            // 입력 줄의 첫 숫자
            int startNode = Integer.parseInt(edgeTokenizer.nextToken());
            // 입력 줄의 두번째 숫자
            int endNode = Integer.parseInt(edgeTokenizer.nextToken());
            // adjList의 startNode번째 리스트에 endNode를 첨부한다.
            // 유향 그래프일 경우 아래 줄만
            adjList.get(startNode).add(endNode);
            // 무향 그래프일 경우 아래 줄도 함께
            adjList.get(endNode).add(startNode);
        }

        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // 목적 : DFS를 했을 때 정점 방문 순서 기록
    public void recursive(
            // 다음 (이번 호출)에서 방문할 곳
            int next,
            // 원활한 순회를 위한 maxNodes
            int maxNodes,
            // 인접 정점 정보 (그래프 정보)
            int[][] adjMatrix,
            // 여태까지 방문한 정점 정보
            boolean[] visited,
            // 요부분은 구하고자 하는 목적에 따라 다릅니다.
            // 방문 순서 기록을 위한 리스트
            List<Integer> visitOrder
    ) {
        visited[next] = true;
        visitOrder.add(next);
        // 반복문에서 재귀호출 한다.
        for (int i = 0; i < maxNodes; i++) {
            // 연결이 되어있으며, 방문한 적 없을 때
            if (adjMatrix[next][i] == 1 && !visited[i])
                recursive(i, maxNodes, adjMatrix, visited, visitOrder);
        }
    }

    public static void main(String[] args) throws IOException {
        new RecursiveDFS().solution();
    }

/*
8 10
0 1
0 2
0 3
1 3
1 4
2 5
3 4
4 7
5 6
6 7
 */ // 10개의 줄에 걸쳐서 간선이 연결된 정점들 (간선 정보)
}
