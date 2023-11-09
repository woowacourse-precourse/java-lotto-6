package lotto.global.constant;

public enum NumberDefinition {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    LOTTO_NUMBER_COUNT(6),

    MINIMUM_MATCH(3),
    BONUS_NUMBER_MATCH_CRITERIA(5);

    private final int number;

    NumberDefinition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
