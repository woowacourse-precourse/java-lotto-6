package lotto.util.constants;

public enum DomainConstants {
    LOTTO_PRICE(1000),
    RANDOM_START_NUMBER(1),
    RANDOM_END_NUMBER(45),
    RANDOM_COUNT_NUMBER(6),
    FIRST_RANK(1),
    SECOND_RANK(2),
    THIRD_RANK(3),
    FIRST_RANK_CONDITION(6),
    SECOND_RANK_CONDITION(5),
    THIRD_RANK_CONDITION(5),
    FOURTH_RANK_CONDITION(4),
    FIFTH_RANK_CONDITION(3),
    BONUS_CHECK_CONDITION(5);

    private final int number;

    DomainConstants(int number) {
        this.number = number;
    }

    public int getConstants() {
        return number;
    }
}
