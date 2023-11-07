package lotto.domain;

import lotto.constant.JudgeBonus;

public class PrizeTotalNUmber {
    private final WinnerNumbers winnerNumbers;
    private final BonusNumber bonusNumber;

    public PrizeTotalNUmber(WinnerNumbers winnerNumbers, BonusNumber bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Integer matchWithWinnerNumbers(Lotto lotto) {
        Integer matchCount = 0;
        for(Integer number : lotto.getNumbers()) {
            if(winnerNumbers.isMatched(number)) matchCount++;
        }
        return matchCount;
    }

    public JudgeBonus matchWithBonusNumber(Lotto lotto) {
        for(Integer number : lotto.getNumbers()) {
            if(bonusNumber.isMatched(number)) return JudgeBonus.BONUS_EQUAL;
        }
        return JudgeBonus.BONUS_UNEQUAL;
    }

}
