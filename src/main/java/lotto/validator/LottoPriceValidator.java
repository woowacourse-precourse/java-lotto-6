package lotto.validator;

import java.math.BigDecimal;

public class LottoPriceValidator {

    private static final int LOTTO_ONE_PRICE = 1000;

    public static void validate(String input) {
        validateLottoPriceNotNumber(input);
        validateLottoPriceNotDivided(input);
        validateLottoPriceFirstZero(input);
    }

    private static void validateLottoPriceNotNumber(String input) throws IllegalArgumentException {
        if (!ValidationUtil.isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validateLottoPriceNotDivided(String input) throws IllegalArgumentException {
        BigDecimal num = new BigDecimal(input);
        if (!num.remainder(BigDecimal.valueOf(LOTTO_ONE_PRICE)).equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 작성되어야 합니다.");
        }
    }

    private static void validateLottoPriceFirstZero(String input) throws IllegalArgumentException {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하는 값을 입력하면 안됩니다.");
        }
    }

}

