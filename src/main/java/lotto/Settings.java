package lotto;

public enum Settings {
    MINIMUM(1),
    MAXIMUM(45),
    SIZE(6),
    BONUS_NUMBER_SIZE(1),
    PURCHASE_UNIT(1000);

    private final int number;

    Settings(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
