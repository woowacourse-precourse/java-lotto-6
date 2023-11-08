package lotto.util.validator;

import lotto.error.LottoErrorMessage;

import java.util.NoSuchElementException;

public class Validator {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static void validateNumeric(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            throw new NoSuchElementException(LottoErrorMessage.NOT_FORMATTING_EXCEPTION.getMessage());
        }
    }
}
