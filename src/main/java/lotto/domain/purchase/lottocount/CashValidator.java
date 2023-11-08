package lotto.domain.purchase.lottocount;

import static lotto.domain.purchase.lottocount.CashPolicy.CASH_REGEX;
import static lotto.domain.purchase.lottocount.CashPolicy.MAX_CASH;
import static lotto.domain.purchase.lottocount.CashPolicy.PRICE_PER_LOTTO;
import static lotto.domain.utils.CustomValidator.validate;

import java.util.function.Consumer;
import java.util.regex.Pattern;

public final class CashValidator {
    public static Consumer<String> validateCashInput = input -> {
        validate(!Pattern.matches(CASH_REGEX, input), "1 이상의 정수만 입력해주세요.");
        validate(Integer.parseInt(input) > MAX_CASH, "1 이상의 정수만 입력해주세요.");
        validate(Integer.parseInt(input) % PRICE_PER_LOTTO != 0, PRICE_PER_LOTTO + " 단위의 금액만 입력해주세요.");
    };
}
