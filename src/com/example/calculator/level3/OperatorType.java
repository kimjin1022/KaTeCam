package com.example.calculator.level3;

public enum OperatorType {
    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType fromString(String input) {
        for (OperatorType op : OperatorType.values()) {
            if (op.symbol.equals(input)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
}
