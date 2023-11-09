package lotto.input;

import java.util.regex.Pattern;

public class InputValidator {

    public static void validateNumber(String input) {
        if (!Pattern.matches("^\\d+$", input)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static void validateList(String lottoNumberInput) {
        if (!Pattern.matches("^\\d+(,\\d+)*$", lottoNumberInput)) {
            throw new IllegalArgumentException("양식에 맞게 입력해 주세요.");
        }
    }
}
