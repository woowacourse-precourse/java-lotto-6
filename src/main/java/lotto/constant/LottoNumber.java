package lotto.constant;

public enum LottoNumber {
    ZERO(0),
    WINNING_NUMBER_LENGTH(6);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
