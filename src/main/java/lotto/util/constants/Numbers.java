package lotto.util.constants;

public enum Numbers {
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_PRICE(1000),
    VALID_NUMBER_LIST_SIZE(6),
    FIRST_PRIZE_MATCH_COUNT(6),
    BONUS_INCLUDED_START_RANK(7),
    BONUS_NOT_INCLUDED_START_RANK(8),
    REWARD_CRITERIA(5),
    PERCENTAGE(100);

    private final Integer number;

    Numbers(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }
}
