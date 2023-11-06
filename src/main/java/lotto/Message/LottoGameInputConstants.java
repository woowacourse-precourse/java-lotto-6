package lotto.Message;

public enum LottoGameInputConstants {
    LOTTO_NUM_AMOUNT(6),
    LOTTO_WINNING_NUM_AMOUNT(6),
    LOTTO_BONUS_NUM_AMOUNT(1),
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_MATCH_WITH_BONUS(30000000),
    SIX_MATCH(2000000000);


    private int num;
    LottoGameInputConstants(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
