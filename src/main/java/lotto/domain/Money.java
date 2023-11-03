package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.exception.Message.CANNOT_BUY_LOTTO_EXCEPTION;

public class Money {
    private final long fee;

    public Money(long fee) {
        this.fee = fee;
    }

    public long toLottoCnt() {
        if (dividable()) {
            throw new IllegalArgumentException(CANNOT_BUY_LOTTO_EXCEPTION);
        }
        return fee / LOTTO_PRICE;
    }

    private boolean dividable() {
        return fee % LOTTO_PRICE > 0;
    }
}

