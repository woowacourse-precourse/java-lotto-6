package lotto.settings;

public enum LottoSettings {

    MIN_VALUE(1),
    MAX_VALUE(45),
    LOTTO_NUMBER_SIZE(6),
    ONE_lOTTO_PRICE(1000);

    private final int number;

    LottoSettings(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
