package lotto.validator;

import lotto.model.LottoNumber;

public class BonusNumberInputValidator {
    private static final String INPUT_NOT_NUMERIC = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 입력값이 1과 45 사이여야 합니다.";

    public static void validate(String input) {
        validateNumberIfNumeric(input);
        validateNumberRange(input);
    }

    private static void validateNumberIfNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC);
        }
    }

    private static void validateNumberRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (!LottoNumber.isInRange(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }
}
