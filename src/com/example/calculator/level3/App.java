package com.example.calculator.level3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            System.out.println("\n명령어 입력:");
            System.out.println("- 종료: exit");
            System.out.println("- 결과 조회: get");
            System.out.println("- 결과 전체 수정: set");
            System.out.println("- 가장 오래된 결과 삭제: del");
            System.out.println("- 특정 값보다 큰 결과만 보기: filter");
            System.out.println("- 계산 계속 진행: 아무 키나 입력");
            System.out.print("입력 : ");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            if (command.equals("get")) {
                System.out.println("현재 저장된 결과 : " + calculator.getResults());
                continue;
            }

            if (command.equals("set")) {
                System.out.print("새로운 결과들을 입력하세요 (예: 1.1 2.2 3.3): ");
                String inputLine = scanner.nextLine();
                calculator.setResults(inputLine);
                System.out.println("결과가 수정되었습니다: " + calculator.getResults());
                continue;
            }

            if (command.equals("del")) {
                calculator.removeOldestResult();
                System.out.println("가장 오래된 결과가 삭제되었습니다: " + calculator.getResults());
                continue;
            }

            if (command.equals("filter")) {
                System.out.print("기준값을 입력하세요: ");
                double threshold = Double.parseDouble(scanner.nextLine());
                System.out.println("해당 값보다 큰 결과 : " + calculator.getResultsGreaterThan(threshold));
                continue;
            }

            // 계산 흐름
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String oper = scanner.nextLine();

            try {
                OperatorType operator = OperatorType.fromString(oper);
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("계산 결과는 " + result + " 입니다");
            } catch (Exception e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
