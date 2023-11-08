package lotto.constant;

public enum LottoGameConfig {
    LOTTO_NUMBER_COUNT(6),
    MIN_LOTTO_NUMBER_RANGE(1),
    MAX_LOTTO_NUMBER_RANGE(45),
    LOTTO_TICKET_PRICE_UNIT(1000);
    private final int number;

    LottoGameConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}