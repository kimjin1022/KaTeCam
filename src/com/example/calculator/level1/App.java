package com.example.calculator.level1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("종료를 원하시면 exit를 입력하세요. 계속 진행을 원하시면 아무키를 입력하세요.");
            System.out.print("입력 : ");
            String command = scanner.nextLine();

            if (command.equals("exit")){
                System.out.println("계산기를 종료합니다.");
                break;
            }

            System.out.print("첫 번쨰 숫자를 입력하세요 : ");
            int num1 = scanner.nextInt();

            System.out.print("두 번쨰 숫자를 입력하세요 : ");
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : ");
            String tmp = scanner.nextLine(); // 버퍼 클리어용
            String oper = scanner.nextLine();

            int result = 0;
            boolean valid = true;

            switch (oper){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0){
                        System.out.println("0으로는 나눌 수 없습니다. 다시 시도하세요.");
                        valid = false;
                        break;
                    }

                    result = num1 / num2;
                    break;

            }

            if (valid){
                System.out.println("계산 결과는 " + result + " 입니다");
            }

        }
    }
}
