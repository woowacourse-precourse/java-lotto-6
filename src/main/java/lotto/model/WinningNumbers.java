package lotto.model;

import static lotto.constant.NumberConstant.CHECK_BONUS_NUMBER_CONDITION;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers createWinningNumbers(Lotto winningNumbers, int bonusNumber){
        return new WinningNumbers(winningNumbers,bonusNumber);
    }

    public Rank determineRank(Lotto lotto) {

        int matchNumberCount = lotto.countCommonNumberFromAnotherLotto(this.winningNumbers);
        boolean bonus = checkExistBonusNumber(lotto, matchNumberCount);

        return Rank.judge(matchNumberCount,bonus);
    }

    public boolean checkExistBonusNumber(Lotto lotto, int matchNumberCount) {
        boolean bonus = false;
        if (isSameBonusNumberCondition(matchNumberCount)) {
            bonus = lotto.containsBonusNumber(this.bonusNumber);
        }
        return bonus;
    }

    public boolean isSameBonusNumberCondition(int matchNumberCount) {
        return matchNumberCount == CHECK_BONUS_NUMBER_CONDITION.value();
    }

}
