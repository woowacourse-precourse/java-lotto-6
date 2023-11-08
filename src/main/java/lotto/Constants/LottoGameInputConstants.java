package lotto.Constants;

public enum LottoGameInputConstants {
    LOTTO_NUM_AMOUNT(6),
    LOTTO_WINNING_NUM_AMOUNT(6),
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45);


    private int num;

    LottoGameInputConstants(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
