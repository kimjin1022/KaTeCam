package com.example.calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, String oper){
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
            results.add(result);
            return result;
        }
        else {
            return -1;
        }
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(String inputLine) {
        String[] tokens = inputLine.split(" ");
        List<Integer> newResults = new ArrayList<>();

        for (String token : tokens) {
            newResults.add(Integer.parseInt(token));
        }

        this.results = newResults;
    }

    public void removeOldestResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

}
