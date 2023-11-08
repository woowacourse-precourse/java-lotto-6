package lotto.util.validator;

import static lotto.domain.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.domain.constant.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.List;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateDuplicates(bonusNumber, winningNumbers);
    }

    public static void validateRange(int winningNumber) {
        if (!isInRange(winningNumber)) {
            throw new IllegalArgumentException("로또 숫자는 "+MIN_LOTTO_NUMBER+"~"+MAX_LOTTO_NUMBER+" 사이의 숫자여야합니다.");
        }
    }

    private static boolean isInRange(int winningNumber) {
        return winningNumber >= MIN_LOTTO_NUMBER && winningNumber <= MAX_LOTTO_NUMBER;
    }

    private static void validateDuplicates(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력한 당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요.");
        }
    }
}
