package lotto.domain.lottery;

import static lotto.exception.ErrorMessage.DUPLICATE_BONUS_NUMBER;

import java.util.List;
import lotto.Lotto;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(List<Integer> numbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberNotDuplicate(numbers, bonusNumber);

        return new WinningLotto(numbers, bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < NUMBER_START) {
            throw LottoGameException.of(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
        if (bonusNumber > NUMBER_END) {
            throw LottoGameException.of(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private static void validateBonusNumberNotDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw LottoGameException.of(DUPLICATE_BONUS_NUMBER);
        }
    }
}
