package lotto.domain;

import lotto.constant.WinnerType;

public class WinningNumber {
    private final Lotto winningNumber;
    private final int bonus;

    public WinningNumber(Lotto winningNumber, int bonus) {
        this.winningNumber = winningNumber;
        this.bonus = bonus;
    }

    public WinnerType calcWinner(Lotto lotto) {
        int match = winningNumber.matching(lotto);
        boolean isBonusMatched = lotto.contains(bonus);

        return WinnerType.of(match, isBonusMatched);
    }
}
