package org.example.stack;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Stack;

public class PostfixConvert {

    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 5+3*1+(4-9)*3
        String answer = "";

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            // 연산자(+, -, *, /, '(')일 때
            if (isOperator(token)) {
                if (stack.empty()) { // 스택이 비어있다면 push
                    stack.push(token);
                    System.out.println("token = " + token);
                } else { // 스택이 비어있지 않다면, 스택의 제일 위의 연산자가 나보다 우선순위가 낮은 연산자가 올 때까지 pop
                    while (inStackPriority(stack.peek()) >= inComingPriority(token)) {
                        answer += stack.pop();
                        if (stack.empty()) {
                            break;
                        }
                    }
                    stack.push(token);

                }
            } else if (token == ')') {// 닫는 괄호일 때
                // 스택에서 여는 괄호가 나올 때 까지 pop
                char top = stack.pop();
                while (top != '(') {
                    answer += top;
                    top = stack.pop();
                }
            } else { // 숫자일 때 바로 출력
                answer += token;
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println("answer = " + answer);
    }

    private static boolean isOperator(char token) {
        return token == '(' || token == '+' || token == '-' || token == '*' || token == '/';
    }

    // 스택 내부 우선순위
    private static int inStackPriority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '(') {
            return 0;
        }
        throw new IllegalArgumentException("not allowed operator");

    }

    // 스택 외부 우선순위
    private static int inComingPriority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '(') {
            return 3;
        }
        throw new IllegalArgumentException("not allowed operator");
    }
}
