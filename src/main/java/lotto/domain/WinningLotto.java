package lotto.domain;

import java.util.List;
import lotto.validation.Validator;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Validator.validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank confirmWin(final Lotto lotto) {
        int countOfMatch = this.winningNumbers.countOfMatch(lotto);
        boolean matchBonus = lotto.contains(this.bonusNumber);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
