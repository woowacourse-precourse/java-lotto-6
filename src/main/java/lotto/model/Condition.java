package lotto.model;

public enum Condition {
    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_BONUS_MATCH(30000000),
    SIX_MATCH(2000000000);

    private int price;

    Condition(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
