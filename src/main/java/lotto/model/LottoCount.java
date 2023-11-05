package lotto.model;

import lotto.exception.Constant;
import lotto.exception.ErrorMessage;

public class LottoCount {
    private final int amount;
    private final int count;

    private LottoCount(int amount) {
        validateAmount(amount);
        this.amount = amount;
        this.count = calculateLottoCount();
    }

    public static LottoCount createLottoCount(int amount) {
        return new LottoCount(amount);
    }

    public int getLottoCount() {
        return count;
    }

    private void validateAmount(int amount) {
        if (!isDivisible(amount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_ONE_TICKET_PRICE.get());
        }
    }

    private int calculateLottoCount() {
        return amount / Constant.LOTTO_TICKET_PRICE.getIntValue();
    }

    private boolean isDivisible(int amount) {
        return ((amount % Constant.LOTTO_TICKET_PRICE.getIntValue()) == 0);
    }

}