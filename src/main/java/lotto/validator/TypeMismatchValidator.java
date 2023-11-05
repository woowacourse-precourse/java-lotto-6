package lotto.validator;

import lotto.app.AppConstant;

import static lotto.app.AppConstant.*;

public class TypeMismatchValidator {

    public static void validateInputInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_FLAG + "가격정보는 숫자만 입력할 수 있습니다.");
        }
    }
}
