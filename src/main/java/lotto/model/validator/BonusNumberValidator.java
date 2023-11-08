package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import java.util.List;

/**
 * 보너스 번호를 검증한다.
 */
public class BonusNumberValidator {
    /**
     * 보너스 번호가 범위 내인지 확인한다.
     * 1 ~ 45번을 가질 수 있다.
     *
     * @param bonusNumber 보너스 번호
     * @throws IllegalArgumentException 1 ~ 45번이 아닐 경우
     */
    public static void checkInRange(Integer bonusNumber) {
        checkMinimum(bonusNumber);
        checkMaximum(bonusNumber);
    }

    private static void checkMinimum(Integer bonusNumber) {
        if (bonusNumber < MINIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage());
        }
    }

    private static void checkMaximum(Integer bonusNumber) {
        if (bonusNumber > MAXIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage());
        }
    }

    /**
     * 당첨 번호와 중복된 번호가 입력되었는지 검증한다.
     *
     * @param winningNumbers 당첨 번호
     * @param bonusNumber 보너스 번호
     * @throws IllegalArgumentException 당첨 번호와 중복된 번호일 경우
     */
    public static void checkDuplicateWithWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
