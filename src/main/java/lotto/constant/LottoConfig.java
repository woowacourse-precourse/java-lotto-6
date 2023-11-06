package lotto.constant;

public enum LottoConfig {
    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    LottoConfig(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}