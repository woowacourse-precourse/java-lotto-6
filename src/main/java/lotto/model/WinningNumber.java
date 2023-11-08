package lotto.model;

import lotto.util.exception.DuplicatedLottoNumbersException;
import lotto.util.exception.NoWinningNumberException;

public class WinningNumber {
    private Lotto winningNumber;
    private int bonusNumber;

    public void setWinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        checkExistWinningNumber();
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new DuplicatedLottoNumbersException();
        }
    }

    private void checkExistWinningNumber() {
        if (winningNumber == null) {
            throw new NoWinningNumberException();
        }
    }

    public Ranking getRankings(Lotto ticket) {
        int numberOfMatch = ticket.getMatchingCount(winningNumber);
        boolean isBonusMatch = ticket.contains(bonusNumber);
        return Ranking.getRanking(numberOfMatch, isBonusMatch);
    }
}
