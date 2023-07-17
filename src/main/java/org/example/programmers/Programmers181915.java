package org.example.programmers;

public class Programmers181915 {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        char[] my_stringChar = my_string.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < index_list.length; i++) {
            strBuilder.append(my_stringChar[index_list[i]]);
        }
        answer = strBuilder.toString();
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] index_list = new int[] {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
        new Programmers181915().solution("cvsgiorszzzmrpaqpe", index_list);
    }
}
