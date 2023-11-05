package lotto.domain.model;

import java.util.List;
import lotto.constant.LottoRank;

public final class LottoGame {
    private static final int FIVE_COUNT = 5;

    private final PurchasedLottos purchasedLottos;
    private final WinningLotto winningLotto;

    public LottoGame(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
    }

    private boolean isFiveMatched(int matchCount) { return matchCount == FIVE_COUNT; }

    private LottoRank getLottoRankByMatchCountAndBonusMatch(int matchCount, boolean isBonusMatched) {
        if (isFiveMatched(matchCount)) {
            return LottoRank.getByBonusMatchWhenMatchCountIsFive(isBonusMatched);
        }

        return LottoRank.getByMatchCountWhenBonusNotMatched(matchCount);
    }

    private LottoRank createLottoRank(Lotto lotto) {
        int matchCount = winningLotto.getMatchCounts(lotto);
        boolean isBonusMatched = winningLotto.isLottoMatchedWithBonusNumber(lotto);

        return getLottoRankByMatchCountAndBonusMatch(matchCount, isBonusMatched);
    }

    public List<LottoRank> createWinningLottoRanks() {
        List<Lotto> elements = purchasedLottos.getElements();

        return elements.stream()
                .map(this::createLottoRank)
                .filter(LottoRank::isWinningRank)
                .toList();
    }
}
