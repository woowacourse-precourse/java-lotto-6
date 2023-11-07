package lotto.domain;

import java.util.List;
import lotto.common.ErrorMessage;

public class WinningLotto extends Lotto {

    private final Integer bonusNumber;

    private WinningLotto(final List<Integer> numbers, final Integer bonusNumber) {
        super(numbers);

        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, Integer bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public boolean isWinningNumber(final Integer number) {
        return this.getNumbers().contains(number);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        if(this.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.MATCH_WINNING_NUMBERS_WITH_BONUS_ERROR.getMessage());
        }
    }
}
