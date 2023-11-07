package lotto.view;

import lotto.exception.ExceptionMessage;

public final class LottoInputValidator {
    private final static String NUMERIC_PATTERN = "^[0-9]+$";
    private final static String NUMERIC_COMMA_PATTERN = "^[0-9]+(,[0-9]+)*$";
    private final static String COMMA_DELIMITER = ",";

    private LottoInputValidator() {
    }

    public static void validateNumeric(String target) {
        if (!target.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC.getDesc());
        }
    }

    public static void validateNumericCommaUnion(String target) {
        String trim = target.trim();
        if (trim.endsWith(COMMA_DELIMITER) || !trim.matches(NUMERIC_COMMA_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_COMMA.getDesc());
        }
    }

}
