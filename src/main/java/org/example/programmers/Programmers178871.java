package org.example.programmers;

import java.util.Arrays;

public class Programmers178871 {
    public String[] solution(String[] players, String[] callings) {
        for (String name: callings) {
            for (int i = 1; i < players.length; i++) {
                if (players[i].equals(name)) {
                    String temp = players[i];
                    players[i] = players[i - 1];
                    players[i - 1] = temp;
                    break;
                }
            }
        }
        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer = new Programmers178871().solution(players, callings);
        System.out.println(Arrays.toString(answer));
    }
}
