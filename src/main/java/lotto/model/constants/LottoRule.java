package lotto.model.constants;

public enum LottoRule {

    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    MINIMUM_MATCH_SIZE(1),
    LOTTO_NUMBER_LENGTH(6);

    private final int value;

    LottoRule(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
