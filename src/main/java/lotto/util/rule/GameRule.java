package lotto.util.rule;

public enum GameRule {

    RANK_SIZE(5),
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
