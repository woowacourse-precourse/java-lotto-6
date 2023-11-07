package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.utils.ErrorMessage;

public class WinningNumber {
    private final Lotto lotto;
    private final int bonusNumber;
    private static final int BONUS_NUMBER_RANGE_MIN = 1;
    private static final int BONUS_NUMBER_RANGE_MAX = 45;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        if (bonusNumber < BONUS_NUMBER_RANGE_MIN || bonusNumber > BONUS_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_BONUS_NUMBER_NOT_DUPLICATE.getMessage());
        }
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lotto.getNumbers());
    }
}
