package lotto.model;

import static lotto.enumerate.ConfigInteger.LOTTO_PRICE;
import static lotto.enumerate.ConfigInteger.ZERO;
import static lotto.enumerate.ErrorCode.AMOUNT_IS_NOT_LONG;
import static lotto.enumerate.ErrorCode.AMOUNT_IS_UNDER_THOUSAND_WON;
import static lotto.enumerate.ErrorCode.AMOUNT_UNIT_IS_NOT_1000_WON;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

public class Cash {
    private final long cash;

    public Cash(String cash) {
        this.cash = validAmount(cash);
    }

    private static void amountUnderThousandWonValid(long convertedAmount) {
        if (convertedAmount <= ZERO.getInt()) {
            exceptionCodeThrow(AMOUNT_IS_UNDER_THOUSAND_WON);
        }
    }

    private static void unitThousandWonValid(long convertedAmount) {
        if (convertedAmount % LOTTO_PRICE.getInt() != ZERO.getInt()) {
            exceptionCodeThrow(AMOUNT_UNIT_IS_NOT_1000_WON);
        }
    }

    private long convertValid(String amount) {
        try {
            return Long.parseLong(amount);
        } catch (NumberFormatException e) {
            exceptionCodeThrow(AMOUNT_IS_NOT_LONG);
        }
        return ZERO.getInt();
    }

    private long validAmount(String amount) {
        long convertedAmount = convertValid(amount);
        unitThousandWonValid(convertedAmount);
        amountUnderThousandWonValid(convertedAmount);
        return convertedAmount;
    }

    public long cash() {
        return cash;
    }
}
