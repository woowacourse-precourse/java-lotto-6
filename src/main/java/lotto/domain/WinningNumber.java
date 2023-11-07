package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATE;

import lotto.constant.WinnerType;

public class WinningNumber {
    private final Lotto winningNumber;
    private final int bonus;

    public WinningNumber(Lotto winningNumber, int bonus) {
        validate(winningNumber, bonus);
        this.winningNumber = winningNumber;
        this.bonus = bonus;
    }

    private void validate(Lotto winningNumber, int bonus) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE.toString());
        }
    }

    public WinnerType calcWinner(Lotto lotto) {
        int match = winningNumber.matching(lotto);
        boolean isBonusMatched = lotto.contains(bonus);

        return WinnerType.of(match, isBonusMatched);
    }
}
