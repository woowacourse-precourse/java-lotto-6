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
    public static void validateEmptySpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값은 빈칸이 될 수 없습니다.");
        }
    }

    public static void validateDisiblePrice(int input) {
        if (input%1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }
}
