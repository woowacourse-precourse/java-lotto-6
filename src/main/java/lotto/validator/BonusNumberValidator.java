package lotto.validator;

import java.util.List;

public class BonusNumberValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final int MIN_NUBMER = 1;
    private static final int MAX_NUBMER = 45;

    public static void hasDuplicateNumber(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "당첨번호와 중복되는 번호입니다.");
        }
    }

    public static void validateMinNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUBMER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자는 1 이상입니다.");
        }
    }

    public static void validateMaxNumber(int bonusNumber) {
        if (bonusNumber > MAX_NUBMER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자는 45 미만입니다.");
        }
    }
}
