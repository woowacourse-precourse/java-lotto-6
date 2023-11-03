package lotto.domain.util.validator;

import java.util.List;
import lotto.domain.config.LottoConfig;

public class WinningLottoValidator {
    private static final int LOTTO_MINIMUM_NUMBER = LottoConfig.LOTTO_MINIMUM_NUMBER.getValue();
    private static final int LOTTO_MAXIMUM_NUMBER = LottoConfig.LOTTO_MAXIMUM_NUMBER.getValue();

    public static void validate(List<Integer> numbers, Integer bonusNumber) {
        checkBonusNumberInNumbers(numbers, bonusNumber);
        checkBonusNumberInRange(bonusNumber);
    }

    private static void checkBonusNumberInNumbers(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 다른 당첨 번호와 중복됩니다.");
        }
    }

    private static void checkBonusNumberInRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_MINIMUM_NUMBER || bonusNumber > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
