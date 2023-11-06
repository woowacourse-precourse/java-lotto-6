package lotto.domain.purchase.lottocount;

import static lotto.domain.purchase.lottocount.CashPolicy.CASH_REGEX;
import static lotto.domain.purchase.lottocount.CashPolicy.MAX_CASH;
import static lotto.domain.purchase.lottocount.CashPolicy.PRICE_PER_LOTTO;

import java.util.regex.Pattern;
import lotto.domain.exception.ExceptionFormat;

public final class CashValidator {
    public static void validateCashInput(String cashInput) throws IllegalArgumentException {
        if (!Pattern.matches(CASH_REGEX, cashInput)) {
            throw new IllegalArgumentException(ExceptionFormat.formatException("1 이상의 정수만 입력해주세요."));
        }
        if (Integer.parseInt(cashInput) > MAX_CASH) {
            throw new IllegalArgumentException(ExceptionFormat.formatException(MAX_CASH + " 이하의 금액만 입력해주세요."));
        }
        if (Integer.parseInt(cashInput) % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ExceptionFormat.formatException(PRICE_PER_LOTTO + " 단위의 금액만 입력해주세요."));
        }
    }
}
