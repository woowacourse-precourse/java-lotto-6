package lotto.domain;

import lotto.util.Validator;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        validate(winningNumber, bonusNumber);

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }


    public Rank compare(Lotto lottoTicket) {
        int matchCount = lottoTicket.getMatchCount(winningNumber);
        boolean isContainBonusNumber = lottoTicket.isContain(bonusNumber);

        return Rank.getRank(matchCount, isContainBonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        Validator.checkBonusNumber(winningLotto, bonusNumber);
    }
}
