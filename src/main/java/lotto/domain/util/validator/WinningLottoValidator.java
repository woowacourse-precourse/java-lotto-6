package lotto.domain.util.validator;

import java.util.List;
import lotto.domain.config.LottoConfig;
import lotto.domain.config.ValidatorConfig;

public class WinningLottoValidator {
    private static final String ERROR_MESSAGE = ValidatorConfig.ERROR_MESSAGE.getMessage();
    private static final String BONUS_NUMBER_SIZE_ERROR_MASSAGE = "보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String DUPLICATION_BONUS_NUMBER_ERROR_MASSAGE = "보너스 번호가 다른 당첨 번호와 중복됩니다.";
    private static final int LOTTO_MINIMUM_NUMBER = LottoConfig.MINIMUM_NUMBER.getValue();
    private static final int LOTTO_MAXIMUM_NUMBER = LottoConfig.MAXIMUM_NUMBER.getValue();

    private WinningLottoValidator() {
    }

    public static void validate(List<Integer> numbers, Integer bonusNumber) {
        checkBonusNumberInNumbers(numbers, bonusNumber);
        checkBonusNumberInRange(bonusNumber);
    }

    private static void checkBonusNumberInNumbers(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATION_BONUS_NUMBER_ERROR_MASSAGE);
        }
    }

    private static void checkBonusNumberInRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_MINIMUM_NUMBER || bonusNumber > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE + String.format(BONUS_NUMBER_SIZE_ERROR_MASSAGE, LOTTO_MINIMUM_NUMBER,
                            LOTTO_MAXIMUM_NUMBER));
        }
    }
}
