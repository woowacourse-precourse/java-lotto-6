package lotto.domain;

import lotto.congin.LottoConfing;

public class LottoMoney {
    private static final int ZERO = 0;
    private static final int ONE_HUNDRED_PERCENT = 100;
    private final int value;

    public LottoMoney(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if ((value % LottoConfing.LOTTO_PRICE) != ZERO) {
            throw new IllegalArgumentException("단위에 맞게 입력 해주세요");
        }
    }

    public int getLottoCount() {
        return value / LottoConfing.LOTTO_PRICE;
    }

    public float getLottoYield(int investmentProfit){
        return ((float) investmentProfit / value) * ONE_HUNDRED_PERCENT;
    }

}
