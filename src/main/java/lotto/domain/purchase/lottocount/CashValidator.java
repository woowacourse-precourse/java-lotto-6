package lotto.domain.purchase.lottocount;

import static lotto.domain.purchase.lottocount.CashPolicy.CASH_REGEX;
import static lotto.domain.purchase.lottocount.CashPolicy.MAX_CASH;
import static lotto.domain.purchase.lottocount.CashPolicy.PRICE_PER_LOTTO;

import java.util.function.Consumer;
import java.util.regex.Pattern;
import lotto.domain.exception.ExceptionFormat;

public final class CashValidator {
    public static Consumer<String> validateCashInput = input -> {
        if (!Pattern.matches(CASH_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionFormat.formatException("1 이상의 정수만 입력해주세요."));
        }
        if (Integer.parseInt(input) > MAX_CASH) {
            throw new IllegalArgumentException(ExceptionFormat.formatException(MAX_CASH + " 이하의 금액만 입력해주세요."));
        }
        if (Integer.parseInt(input) % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ExceptionFormat.formatException(PRICE_PER_LOTTO + " 단위의 금액만 입력해주세요."));
        }
    };
}
