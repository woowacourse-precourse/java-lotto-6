package lotto.global.utils;

import lotto.global.constant.CommonCode;
import lotto.module.domain.Lotto;

public class
ValidatorUtils {

    public static Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수값이 아닙니다.");
        }
    }

    public static void validateUnit(int amount, int unit) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException("[ERROR] 최소 단위에 부합하지 않습니다.");
        }
    }

    public static void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("[ERROR] 허용된 범위에 포함되지 않습니다.");
        }
    }

    public static Integer validateBuyAmount(String input) {
        Integer buyAmount = ValidatorUtils.parseInt(input);
        ValidatorUtils.validateUnit(buyAmount, CommonCode.BUY_MIN_UNIT);

        return buyAmount;
    }

    public static Integer validateBonusNumber(Lotto winLotto, String input) {
        Integer bonusNumber = ValidatorUtils.parseInt(input);
        ValidatorUtils.validateRange(bonusNumber, CommonCode.MIN_LOTTO_NUM, CommonCode.MAX_LOTTO_NUM);

        if (winLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 포함되지 않은 숫자여야 합니다.");
        }

        return bonusNumber;
    }
}