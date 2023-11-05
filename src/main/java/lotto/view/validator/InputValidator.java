package lotto.view.validator;

import org.junit.platform.commons.util.StringUtils;

public class InputValidator {
    private static final String INVALID_INPUT_EXCEPTION_MESSAGE = "입력은 공백일 수 없습니다.";

    protected static void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
