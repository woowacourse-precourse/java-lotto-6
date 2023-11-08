package lotto.domain.constants;

public enum LottoConstraint {
    LOTTO_PRICE(1000),
    NUMBER_RANGE_MINIMUM(1),
    NUMBER_RANGE_MAXIMUM(45),
    NUMBER_COUNT(6),

    FIRST_REWARD(2000000000),
    SECOND_REWARD(30000000),
    THIRD_REWARD(1500000),
    FOURTH_REWARD(50000),
    FIFTH_REWARD(5000);

    private final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
