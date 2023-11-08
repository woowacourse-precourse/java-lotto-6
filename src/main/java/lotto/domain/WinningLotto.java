package lotto.domain;

import java.util.List;
import lotto.exception.LottoExceptionMessages;
import lotto.exception.WinningLottoExceptionMessages;
import lotto.view.OutputView;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;
    public static final int LOWER_BOUND_OF_BONUS_NUMBER = 1;
    public static final int UPPER_BOUND_OF_BONUS_NUMBER = 45;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        validate(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private static void validate(final Lotto lotto, final int bonusNumber) {
        validateNoDuplicate(lotto, bonusNumber);
        validateRange(bonusNumber);
    }

    private static void validateNoDuplicate(final Lotto lotto, final int bonusNumber) {
        if (lotto.isContains(bonusNumber)) {
            OutputView.println(WinningLottoExceptionMessages.EXPECTED_NO_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(final int bonusNumber) {
        if (bonusNumber < LOWER_BOUND_OF_BONUS_NUMBER || bonusNumber > UPPER_BOUND_OF_BONUS_NUMBER) {
            OutputView.println(LottoExceptionMessages.EXPECTED_VALID_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public int countDuplicateNumbers(final Lotto lotto) {
        return lotto.countDuplicateNumbers(this.lotto);
    }

    public boolean containsBonusNumber(final Lotto lotto) {
        return lotto.isContains(bonusNumber);
    }
}
