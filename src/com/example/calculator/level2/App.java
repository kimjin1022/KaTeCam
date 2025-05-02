package com.example.calculator.level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true){
            System.out.println("\n명령어 입력:");
            System.out.println("- 종료: exit");
            System.out.println("- 결과 조회: get");
            System.out.println("- 결과 전체 수정: set");
            System.out.println("- 가장 오래된 결과 삭제: del");
            System.out.println("- 계산 계속: 아무 키나 입력");
            System.out.print("입력 : ");
            String command = scanner.nextLine();


            if (command.equals("exit")){
                System.out.println("계산기를 종료합니다.");
                break;
            }

            if (command.equals("get")){
                System.out.println("현재 저장된 결과 : " +calculator.getResults());
                continue;
            }

            if (command.equals("del")) {
                calculator.removeOldestResult();
                System.out.println("가장 오래된 결과 삭제: " + calculator.getResults());
                continue;
            }

            if (command.equals("set")) {
                System.out.print("새로운 결과들을 입력하세요 (공백 구분, 예: 1 2 3): ");
                String inputLine = scanner.nextLine();
                calculator.setResults(inputLine);
                System.out.println("결과가 수정되었습니다: " + calculator.getResults());
                continue;
            }



            System.out.print("첫 번쨰 숫자를 입력하세요 : ");
            int num1 = scanner.nextInt();

            System.out.print("두 번쨰 숫자를 입력하세요 : ");
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : ");
            String tmp = scanner.nextLine(); // 버퍼 클리어용
            String oper = scanner.nextLine();

            int result = calculator.calculate(num1, num2, oper);
            System.out.println("계산 결과는 " + result + " 입니다");

        }
    }
}
