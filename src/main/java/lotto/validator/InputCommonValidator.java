package lotto.validator;

public class InputCommonValidator {

    private static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자만 입력해야 합니다.";

    private InputCommonValidator() {
    }

    public static void validate(final String inputPrice) {
        validateNumber(inputPrice);
    }

    private static void validateNumber(final String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }
}
