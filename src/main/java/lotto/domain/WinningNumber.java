package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningNumber {
    private final Lotto lottoNumber;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto lottoNumber, BonusNumber bonusNumber) {
        validateLottoNumberContainBonusNumber(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        int matchCount = lotto.getMatchCount(lottoNumber);
        boolean bonusMatched = lotto.contains(bonusNumber);
        Rank rank = Rank.findByMatchCount(matchCount, bonusMatched);
        rank.addCount();
        return Rank.findByMatchCount(matchCount, bonusMatched);
    }

    private void validateLottoNumberContainBonusNumber(Lotto lottoNumber, BonusNumber bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) throw new IllegalArgumentException("보너스 번호가 당첨 번호 6개 중에 포함되어있습니다.");
    }
}
