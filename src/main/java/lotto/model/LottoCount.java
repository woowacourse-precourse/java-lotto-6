package lotto.model;

import lotto.common.Constant;
import lotto.common.ErrorMessage;

public class LottoCount {
    private final int amount;
    private final int count;

    private LottoCount(int amount) {
        validateAmount(amount);
        this.amount = amount;
        this.count = calculateLottoCount();
    }

    public static LottoCount createLottoCount(String amount) {
        return new LottoCount(convertStringToInt(amount));
    }

    private static int convertStringToInt(String amount) {
        isNULL(amount);
        isContainsBlank(amount);
        return Integer.parseInt(amount);
    }

    public int getLottoCount() {
        return count;
    }

    private void validateAmount(int amount) {
        if (!isMinAmount(amount)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_MIN_TICKET_PRICE.get());
        }
        if (!isDivisible(amount)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AMOUNT_IS_NOT_DIVISIBLE.get());
        }
    }

    private static void isNULL(String amount) {
        if(amount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AMOUNT_NULL.get());
        }
    }

    private static void isContainsBlank(String amount) {
        if(amount.contains(Constant.BLANK.getCharValue())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AMOUNT_CONTAINS_BLANK.get());
        }
    }

    private int calculateLottoCount() {
        return amount / Constant.LOTTO_TICKET_PRICE.getIntValue();
    }

    private boolean isDivisible(int amount) {
        return ((amount % Constant.LOTTO_TICKET_PRICE.getIntValue()) == 0);
    }

    private boolean isMinAmount(int amount) {
        return (amount >= Constant.LOTTO_TICKET_PRICE.getIntValue());
    }

}