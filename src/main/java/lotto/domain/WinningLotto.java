package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.Rank;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, LottoNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.countMatchedNumbers(winningLotto);
        boolean containsBonus = lotto.contains(bonusNumber);
        return Rank.findRankByMatchAndBonus(matchCount, containsBonus);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBERS_INCLUDE_BONUS_MESSAGE.getMessage());
        }
    }
}
