package lotto.util.constant;

public enum GameRule {

    LOTTO_SIZE(6),
    MIN_LOTTO_RANGE(1),
    MAX_LOTTO_RANGE(45),
    TICKET_PRICE(1000);

    private final Integer value;

    GameRule(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
