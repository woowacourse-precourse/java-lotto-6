package lotto.domain.validator;

import lotto.domain.Lotto;

public class ValidateBonusBall {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String RANGE_ERROR_NEGATIVE = "1보다 작은 숫자는 입력 할 수 없습니다.";
    private static final String RANGE_ERROR_POSITIVE = "45보다 큰 숫자는 입력 할 수 없습니다.";
    private static final String BONUS_BALL_ERROR_DUPLICATE = "보너스볼의 숫자와 같은 숫자가 존재합니다.";

    public static void isInRange(int bonusBall) {
        if (bonusBall < MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_HEAD + RANGE_ERROR_NEGATIVE);
        }
        if (bonusBall > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_HEAD + RANGE_ERROR_POSITIVE);
        }
    }

    public static void isDuplicate(int bonusBall, Lotto lotto) {
        if (lotto.hasNumber(bonusBall)) {
            throw new IllegalArgumentException(ERROR_HEAD + BONUS_BALL_ERROR_DUPLICATE);
        }
    }
}
