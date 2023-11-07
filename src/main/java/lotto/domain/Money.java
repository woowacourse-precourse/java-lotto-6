package lotto.domain;

import java.util.regex.Pattern;
import lotto.domain.constant.LottoConstant;
import lotto.exception.NonNumberException;
import lotto.exception.money.MinimumMoneyException;
import lotto.exception.money.MoneyOutOfRangeException;
import lotto.exception.money.MoneyUnitException;

public class Money {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?\\d+$");
    private int amount;

    private Money(final int amount) {
        this.amount = amount;
    }

    public static Money of(final String amount) {
        validate(amount);
        return new Money(parseNumeric(amount));
    }

    public int calculateLottoQuantity(final int price) {
        return this.amount / price;
    }

    public float calculateLottoProfitRate(final long prize) {
        return (float) prize / this.amount * 100;
    }

    private static void validate(final String amount) {
        isNumeric(amount);
        isOverThousand(amount);
        isDivisibleByThousand(amount);
    }

    private static void isNumeric(final String amount) {
        if (!NUMBER_PATTERN.matcher(trim(amount)).matches()) {
            throw new NonNumberException();
        }
    }

    private static void isOverThousand(final String amount) {
        if ((parseNumeric(amount) < LottoConstant.PRICE.getValue())) {
            throw new MinimumMoneyException();
        }
    }

    private static void isDivisibleByThousand(final String amount) {
        if ((parseNumeric(amount) % LottoConstant.PRICE.getValue() != 0)) {
            throw new MoneyUnitException();
        }
    }

    private static int parseNumeric(final String input) {
        try {
            return Integer.parseInt(trim(input));
        } catch (NumberFormatException e) {
            throw new MoneyOutOfRangeException();
        }
    }

    private static String trim(final String input) {
        return input.trim();
    }
}