package lotto.domain;

import lotto.constant.WinningGrade;

public final class WinningDetail {

    private final WinningGrade winningGrade;
    private final Integer index;

    public WinningDetail(final WinningGrade winningGrade, final Integer index) {
        this.winningGrade = winningGrade;
        this.index = index;
    }

    public WinningGrade toWinningGrade() {
        return this.winningGrade;
    }

    public Integer toIndex() {
        return this.index;
    }

    public boolean isPossibleSecondWinner() {
        return winningGrade.isPossibleSecondWinner();
    }
}
