package lotto.validator.constants;

public enum InputSetting {
    MAX_PAY_AMOUNT(2_000_000_000),
    MAX_NUMBER_DIGIT(10);

    private final int value;

    InputSetting(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
