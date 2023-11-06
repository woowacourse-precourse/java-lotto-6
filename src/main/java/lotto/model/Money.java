package lotto.model;

import java.util.Arrays;

public enum Money {
    THIRD(5000, 3, "3개 일치 (5,000원)"),

    FOURTH(50000, 4, "4개 일치 (50,000원)"),

    FIFTH(1500000, 5, "5개 일치 (1,500,000원)"),

    FIFTH_BONUS(30000000, 7, "5개 일치, 보너스 볼 일치 (30,000,000원)"),

    SIXTH(2000000000, 6, "6개 일치 (2,000,000,000원)");

    private final int price;
    private final int number;
    private final String print;

    Money(int price, int number, String print) {
        this.price = price;
        this.number = number;
        this.print = print;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public String getPrint() {
        return print;
    }

    public static Money checkTicketScore(int number){
        return Arrays.stream(Money.values())
                .filter(money -> money.getNumber() == number)
                .findAny().orElse(null);
    }
}
