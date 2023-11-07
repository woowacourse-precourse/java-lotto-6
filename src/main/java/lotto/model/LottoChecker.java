package lotto.model;

import java.util.List;

public class LottoChecker {

    private final Lotto winningLotto;
    private final int bonus;

    public LottoChecker(List<Integer> winningNumbers, int bonus) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonus = bonus;
    }

    public LottoResult checkLottos(final List<Lotto> lottos) {
        final LottoResult result = new LottoResult();
        for (final Lotto lotto : lottos) {
            final LottoRank lottoRank = getLottoRank(lotto);
            result.increaseRankCount(lottoRank);
        }
        return result;
    }

    private LottoRank getLottoRank(final Lotto lotto) {
        final int matchCount = winningLotto.getMatchCount(lotto);
        if (matchCount == 5) {
            return LottoRank.valueFrom(matchCount, hasBonusNumber(lotto));
        }
        return LottoRank.valueFrom(matchCount);
    }

    private boolean hasBonusNumber(final Lotto lotto) {
        return lotto.contains(bonus);
    }

}