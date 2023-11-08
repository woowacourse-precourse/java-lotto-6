package lotto.model;

import lotto.model.enums.Rank;
import lotto.model.exceptions.DuplicatedNumberException;

public class WinLotto {
    private final Lotto winLotto;
    private final BonusNumber bonusNumber;

    public WinLotto(Lotto winLotto, BonusNumber bonusNumber) {
        checkDuplicateNumber(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicateNumber(Lotto winLotto, BonusNumber bonusNumber) {
        if (winLotto.contains(bonusNumber.number())) {
            throw new DuplicatedNumberException();
        }
    }

    public Rank calculateLottoRank(Lotto lotto) {
        int count = winLotto.calculateSameNumberCount(lotto);
        boolean isBonus = false;
        if (Rank.isThirdCount(count)) {
            isBonus = lotto.contains(bonusNumber.number());
        }
        return Rank.calculateRank(count, isBonus);
    }
}