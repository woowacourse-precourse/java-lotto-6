package lotto.constants;

public enum ViewConstants {

    LOTTO_THREE_NUMBER_MATCH(3),
    LOTTO_FOUR_NUMBER_MATCH(4),
    LOTTO_FIVE_NUMBER_MATCH(5),
    LOTTO_SIX_NUMBER_MATCH(6);

    private final int value;

    ViewConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
