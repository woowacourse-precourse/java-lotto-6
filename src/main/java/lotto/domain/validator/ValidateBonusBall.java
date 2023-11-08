package lotto.domain.validator;

import lotto.domain.Lotto;

public class ValidateBonusBall {

    public static void isInRange(int bonusBall) {
        if (bonusBall < 1) {
            throw new IllegalArgumentException("[ERROR] 1보다 작은 숫자는 입력 할 수 없습니다.");
        }
        if (bonusBall > 45) {
            throw new IllegalArgumentException("[ERROR] 45보다 큰 숫자는 입력 할 수 없습니다.");
        }
    }

    public static void isDuplicate(int bonusBall, Lotto lotto) {
        if (lotto.hasNumber(bonusBall)) {
            throw new IllegalArgumentException("[ERROR] 보너스볼의 숫자와 같은 숫자가 존재합니다.");
        }
    }
}
