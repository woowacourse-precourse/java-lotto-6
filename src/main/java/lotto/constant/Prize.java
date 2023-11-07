package lotto.constant;

public enum Prize {
    SIX_MATCH(2000000000),
    FIVE_AND_BONUS_MATCH(30000000),
    FIVE_MATCH(1500000),
    FOUR_MATCH(50000),
    THREE_MATCH(5000),
    NO_GRADE(0),
    ;

    private final Integer price;

    Prize(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
