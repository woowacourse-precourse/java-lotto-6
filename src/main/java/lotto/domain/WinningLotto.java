package lotto.domain;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }


    public Rank confirmWin(final Lotto lotto) {
        int countOfMatch = this.winningNumbers.countOfMatch(lotto);
        boolean matchBonus = lotto.contains(this.bonusNumber);
        return Rank.valueOf(countOfMatch, matchBonus);
    }


    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < Constant.MIN_NUMBER || bonusNumber > Constant.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
    }
}
