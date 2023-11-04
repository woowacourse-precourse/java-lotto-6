package lotto.constant;

public enum LottoInfo {

    LOTTO_SIZE(6),
    LOTTO_PRICE(1000),
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    BONUS_NUMBER_SIZE(1);

    private int info;

    LottoInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

}
