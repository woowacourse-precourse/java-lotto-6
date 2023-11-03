package lotto.domain;

import lotto.congin.LottoConfing;

public class LottoTicket {
    private static final int ZERO = 0;
    private final int value;

    public LottoTicket(int value) {
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

}
