package org.example.string;

public class AlphaToInteger {
    // 숫자로만 이루어진 value 문자열에 대해서
    // 각 글자를 숫자 데이터로 해석한 뒤
    // -48 하면 숫자가 된다/
    public int atoi(String value) {
        int result = 0;
        int negative = 1;

        // 문자열을 한글자씩 확인
        for (int i = 0; i < value.length(); i++) {
            // 문자열을 한글자씩 확인
            char ch = value.charAt(i);
            // 음수인지 확인하고 음수일 경우 negative를 -1로 줌
            if (ch == '-') negative = -1;
            // 아닐 경우 숫자로 변환
            else result = result * 10 + (ch - '0');
        }

        return result * negative;
    }



    public static void main(String[] args) {
        AlphaToInteger atoi = new AlphaToInteger();
        System.out.println(atoi.atoi("12345"));
        System.out.println(atoi.atoi("-4291"));
    }
}
