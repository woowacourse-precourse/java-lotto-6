package lotto.validator;

import lotto.domain.WinningLotto;

public class BonusValidator {

    private static final int BONUS_MIN_NUMBER = 1;
    private static final int BONUS_MAX_NUMBER = 45;

    public static void validate(int number) {
        validateRange(number);
    }

    private static void validateRange(int number) {
        if (number < BONUS_MIN_NUMBER || number > BONUS_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이여야 합니다.");
        }
    }
}
