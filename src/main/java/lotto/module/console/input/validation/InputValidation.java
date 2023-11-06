package lotto.module.console.input.validation;

import lotto.global.exception.LottoException;

/**
 * 입력값 유효성 검사 클래스
 */
public class InputValidation {
    private static final String LOTTO_NUMBER_RANGE_REGEX = "^[1-9]|[1-3][0-9]|4[0-5]$"; // 1에서 45까지의 숫자를 나타내는 정규표현식
    private static final String ONLY_NUMBER_REGEX = "\\d+";

    private InputValidation() {
    }

    public static InputValidation newInstance() {
        return new InputValidation();
    }

    public void validatePurchaseAmountString(final String inputPurchaseAmount) {
        if (!inputPurchaseAmount.matches(ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException(LottoException.INVALID_PURCHASE_AMOUNT_STRING_VALIDATION.getDefaultMessage());
        }
    }

    public void validateLottoNumbersRange(final String number) {
        if (!number.matches(LOTTO_NUMBER_RANGE_REGEX)) {
            throw new IllegalArgumentException(LottoException.LOTTO_NUMBER_RANGE_VALIDATION.getDefaultMessage());
        }
    }

}
