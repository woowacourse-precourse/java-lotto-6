package lotto.domain;

import lotto.domain.constants.LottoRank;

import java.util.Arrays;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank lottoResult(Lotto lotto) {
        int matchCount = matchCount(lotto);
        boolean bonus = isFiveMatchGreaterThanAndIsBonus(lotto);
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getCount() == matchCount)
                .filter(lottoRank -> lottoRank.isBonus() == bonus)
                .findFirst()
                .orElse(LottoRank.LOSE);
    }

    public boolean isFiveMatchGreaterThanAndIsBonus(Lotto lotto) {
        if (matchCount(lotto) < 5) {
            return false;
        }
        return bonusNumber.isContains(lotto);
    }

    public int matchCount(Lotto lotto) {
        return lotto.matchCount(this.winningLotto);
    }
}
