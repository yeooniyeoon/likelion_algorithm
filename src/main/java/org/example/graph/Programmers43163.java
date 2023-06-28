package org.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!Arrays.asList(words).contains(target)) return answer;

        boolean[] visited = new boolean[words.length];

        // 거리 지정하기 위한 distance 배열
        int[] distance = new int[words.length];

        // begin에서 일단 도달할 수 있는 words 내의 단어를 Queue에 enqueue
        Queue<Integer> toVisit = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            // 시작 단어와 유사한 단어일 경우
            if (similar(begin, words[i])) {
                // Queue에 enqueue
                toVisit.offer(i);
                visited[i] = true;
                distance[i] = 1;
            }
        }

        // BFS 진행
        while (!toVisit.isEmpty()) {
            int nextIdx = toVisit.poll();
            String nextWord = words[nextIdx];
            // 이번 단어가 Target이다.
            if (nextWord.equals(target)) {
                answer = distance[nextIdx];
                break;
            }

            // 다음 방문 대상 선정
            for (int i = 0; i < words.length; i++) {
                // 유사하고, 방문하지 않았다.
                if (similar(nextWord, words[i]) && !visited[i])
                toVisit.offer(i);
                visited[i] = true;
                distance[i] = distance[nextIdx] + 1;
            }
        }

        return answer;
    }

    // 인접 판단 메소드 : 두 단어가 한글자 제외 동일한지
    private boolean similar(String word, String target) {
        // String.charAt(i)
        int k = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(i)) k++;
        }
        return k == word.length() - 1;
    }

    public static void main(String[] args) {
        System.out.println(
                new Programmers43163().solution("hit","cog", new String[] {
                        "hot", "dot", "dog", "lot", "log", 'cog'
                })
        );
        System.out.println();
    }
}
