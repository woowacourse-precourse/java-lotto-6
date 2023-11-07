package lotto.domain;

public class Money {
    private static int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static int trial() {
        return amount / 1000;
    }
}
