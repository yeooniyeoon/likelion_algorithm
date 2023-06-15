package org.example;

import java.util.Optional;

public class Main {
    public static String nullableMethod() {
        return null;
    }

    public static void main(String[] args) {
        String result = nullableMethod();

        // Optional
        Optional<String> optionalValue = Optional.ofNullable(result);

        if (optionalValue.isPresent()) {  // 데이터를 가지고 있을 때
            System.out.println("Value is present: " + optionalValue.get());
        } else {  // 데이터가 존재하지 않을 때
            System.out.println("Value is not present");
        }

        // Optional<T>.orElse(T other) : 데이터가 없을 때 other를 대신 사용
        System.out.println("Value is" + optionalValue.orElse("null"));
    }
}