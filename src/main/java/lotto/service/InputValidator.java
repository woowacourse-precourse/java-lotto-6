package lotto.service;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER = "^[0-9]*$";

    public void validateInputDataIsNumber(String inputData) {
        if (!Pattern.matches(NUMBER, inputData)) {
            throw new IllegalArgumentException("로또 번호는 숫자만 입력 가능합니다.");
        }
    }
}
