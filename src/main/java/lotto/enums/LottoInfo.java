package lotto.enums;

public enum LottoInfo {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBERS_PER_LOTTO(6),
    LOTTO_PRICE(1000);

    private final int number;

    LottoInfo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
