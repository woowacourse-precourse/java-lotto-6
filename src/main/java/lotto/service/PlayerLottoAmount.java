package lotto.service;

import lotto.view.ExceptionMessage;

public class PlayerLottoAmount {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private final int amount;

    public PlayerLottoAmount(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }
}
