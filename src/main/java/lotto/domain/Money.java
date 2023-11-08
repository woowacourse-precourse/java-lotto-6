package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.ZERO;
import static lotto.exception.Message.CANNOT_BUY_LOTTO_EXCEPTION;
import static lotto.exception.Message.MONEY_CREATION_EXCEPTION;

public class Money {
    private final long fee;

    public Money(long fee) {
        if (lessThanZero(fee)) {
            throw new IllegalStateException(MONEY_CREATION_EXCEPTION);
        }
        this.fee = fee;
    }

    private boolean lessThanZero(long fee) {
        return fee < ZERO;
    }

    public long toLottoCnt() {
        if (dividable()) {
            throw new IllegalStateException(CANNOT_BUY_LOTTO_EXCEPTION);
        }
        return fee / LOTTO_PRICE;
    }

    private boolean dividable() {
        return fee % LOTTO_PRICE > ZERO;
    }
}

