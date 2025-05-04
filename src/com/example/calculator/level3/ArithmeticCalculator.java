package com.example.calculator.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> results = new ArrayList<>();

    public double calculate(T num1, T num2, OperatorType operator) {
        double a = num1.doubleValue();
        double b = num2.doubleValue();
        double result = 0;

        switch (operator) {
            case ADD: result = a + b; break;
            case SUB: result = a - b; break;
            case MUL: result = a * b; break;
            case DIV:
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                result = a / b;
                break;
        }

        results.add(result);
        return result;
    }

    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    public void setResults(String inputLine) {
        String[] tokens = inputLine.trim().split(" ");
        List<Double> newResults = new ArrayList<>();
        for (String token : tokens) {
            newResults.add(Double.parseDouble(token));
        }
        this.results = newResults;
    }

    public void removeOldestResult() {
        if (!results.isEmpty()) results.remove(0);
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(r -> r > threshold)
                .collect(Collectors.toList());
    }
}
