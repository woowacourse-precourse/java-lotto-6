package ui.validator;

import java.util.List;
import lotto.LottoConfig;

public class BonusNumberValidator {
    private BonusNumberValidator() {
    }

    public static void verify(List<Integer> commonNumbers, int bonus) {
        if (bonus < LottoConfig.START_NUM || bonus > LottoConfig.END_NUM) {
            throw new IllegalArgumentException("[ERROR] 로또 번호로 적합하지 않은 숫자입니다.");
        }

        if (commonNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 가질 수 없습니다.");
        }
    }
}
