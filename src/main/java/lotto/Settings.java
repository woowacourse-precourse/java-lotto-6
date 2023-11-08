package lotto;

public enum Settings {
    MINIMUM(1),
    MAXIMUM(45),
    SIZE(6),
    BONUS_NUMBER_SIZE(1),
    PURCHASE_UNIT(1000),
    MAIN_MATCH_FOR_FIRST(6),
    MAIN_MATCH_FOR_SECOND(5),
    MAIN_MATCH_FOR_THIRD(5),
    MAIN_MATCH_FOR_FOURTH(4),
    MAIN_MATCH_FOR_FIFTH(3);

    private final int number;

    Settings(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
