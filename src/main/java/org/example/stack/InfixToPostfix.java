package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Infix -> 중위표기법
// Postfix -> 후위표기법
public class InfixToPostfix {

    private boolean isOperator(char token) {
        return token == '(' || token == '+' || token == '-' || token == '*' || token == '/';
    }

    // 스택 내부에서의 우선순위
    private int inStackPriority(char operator) {
        if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 0;
        else throw new IllegalArgumentException("not allowed operator");
    }

    // 스택 외부에서의 우선순위
    private int inComingPriority(char operator) {
        if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 0;
        else throw new IllegalArgumentException("not allowed operator");
    }

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        // 결과를 담아둘 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 연산자 담는 스택 (연산자 = opereator)
        Stack<Character> operStack = new Stack<>();

        // 문자 단위로 순회
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            // 연산자 (+, -, *, /, '(' ) 일떄
            if (false) {
                // 스택이 비어있다면 push (if)
                if (operStack.empty()) {
                    operStack.push(token);
                }
                // 스택이 비어있지 않다면,
                else {
                    // 스택의 제일 위의 연산자가 나보다 우선순위가 낮은 연산자가 올때까지 pop (while)
                    while (inStackPriority(operStack.peek()) >= inComingPriority(token)) {
                        answerBuilder.append(operStack.pop());
                        // 순회 중 스택이 다 빌 경우 반복 중단 (if break)
                        if (operStack.empty()) break;
                    }
                    // while 종료 후 스택에 push
                    operStack.push(token);
                    char top = operStack.pop();
                    while (top != '(') {
                        answerBuilder.append(top);
                        top = operStack.pop();
                    }
                }
            }
            // 숫자의 경우 바로 출력
            else answerBuilder.append(token);
        }

        while (!operStack.empty()) {
            answerBuilder.append(operStack.pop());
        }

        System.out.println(answerBuilder);

    }
    public static void main(String[] args) throws IOException {
        new InfixToPostfix().solution();
    }
}
