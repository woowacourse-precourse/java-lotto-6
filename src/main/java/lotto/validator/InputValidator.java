package lotto.validator;

import java.util.regex.Pattern;

import static lotto.constant.ErrorConstant.ERROR_PREFIX;

public class InputValidator {

    private static final String DIGIT_VALIDATE_REGEX = "-?[0-9]+";

    public void validatePurchaseMoney(String inputPurchaseMoney) {
        if (isNotDigit(inputPurchaseMoney)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매금액은 숫자로 이루어져야 합니다.");
        }
        if (isWrongEndNumber(inputPurchaseMoney)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매금액은 1000단위로 입력해야 합니다.");
        }
    }

    private boolean isNotDigit(String inputPurchaseMoney) {
        return !Pattern.compile(DIGIT_VALIDATE_REGEX).matcher(inputPurchaseMoney).matches();
    }

    private boolean isWrongEndNumber(String inputPurchaseMoney) {
        int purchaseMoney = Integer.parseInt(inputPurchaseMoney);
        return purchaseMoney % 1000 != 0;
    }
}
