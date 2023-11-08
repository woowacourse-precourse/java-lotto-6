package lotto.domain.model;

import java.util.List;
import lotto.constant.LottoRank;

public final class LottoGame {

    private final PurchasedLottos purchasedLottos;
    private final WinningLotto winningLotto;

    public LottoGame(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
    }

    private LottoRank getLottoRankByMatchCountAndBonusMatch(int matchCount, boolean isBonusMatched) {
        return LottoRank.getRankByMatches(matchCount, isBonusMatched);
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
