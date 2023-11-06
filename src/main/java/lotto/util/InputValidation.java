package lotto.util;

import java.util.List;

public class InputValidation {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 금액에 대한 validation
    // 한번에 묶기
    // private과 public 확인

    private static void validateNumericString(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값은 숫자여야 합니다.");
        }
    }
}
