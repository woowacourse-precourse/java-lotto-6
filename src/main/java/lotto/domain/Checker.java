package lotto.domain;

import lotto.Lotto;

public class Checker {
    private int count;
    private boolean bonus;

    public Checker(Lotto lotto, WinningNumber winningNumber) {
        make(lotto, winningNumber);
    }

    private void make(Lotto lotto, WinningNumber winningNumber) {
        for (int number : lotto.getNumbers()) {
            if (winningNumber.getWinningNumber().contains(number)) {
                count++;
            }
            if (number == winningNumber.getBonusNumber()) {
                bonus = true;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return bonus;
    }
}
