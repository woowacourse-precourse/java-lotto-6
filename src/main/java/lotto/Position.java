package lotto;

import java.util.Arrays;

public enum Position {
    EQUAL_3("3개 일치", 5000),
    EQUAL_4("4개 일치", 50000),
    EQUAL_5("5개 일치", 1500000),
    EQUAL_5PLUS("5개 일치, 보너스 볼 일치", 30000000),
    EQUAL_6("6개 일치", 2000000000);

    private final String print;
    private final int money;
    Position(String print, int money) {
        this.print = print;
        this.money = money;
    }

    public String getPositonPrint(){
        return this.print;
    }

    public int getPositionMoney(){
        return this.money;
    }

    public static Position valueOfPrint(String print){
        Position[] values = Position.values();

        for (Position value : values) {
            if (value.print.equals(print)){
                return value;
            }
        }
        return null;
    }
}

