package lotto.domain.lottoTicket;

import lotto.domain.exception.bonusNumberException.BonusNumberContainedException;
import lotto.domain.lottoResult.LottoRank;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final BonusNumber number;

    public WinningLotto(final Lotto winningNumbers, BonusNumber number) {
        validateWinningLotto(winningNumbers, number);
        this.winningNumbers = winningNumbers;
        this.number = number;
    }

    public static WinningLotto of(final Lotto winningNumbers, BonusNumber number) {
        return new WinningLotto(winningNumbers, number);
    }

    private void validateWinningLotto(final Lotto winningNumbers, final BonusNumber number) {
        if (winningNumbers.contains(number.bonusNumber())) {
            throw new BonusNumberContainedException();
        }
    }

    public LottoRank match(Lotto lotto) {
        int matchNumber = lotto.match(winningNumbers);
        boolean isBonus = lotto.contains(number.bonusNumber());

        return LottoRank.ofMatchNumber(matchNumber, isBonus);
    }
}
