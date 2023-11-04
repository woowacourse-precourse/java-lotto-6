package lotto.domain.model;

import java.util.List;
import lotto.constant.LottoRank;

public final class LottoGame {
    private static final int FIVE_COUNT = 5;

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoGame(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    private int getMatchCount(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        long count = numbers.stream().filter(winningLotto::contains).count();

        return Long.valueOf(count).intValue();
    }

    private boolean getIsBonusMatched(Lotto lotto) {
        LottoBonusNumber bonusNumber = winningLotto.getBonusNumber();

        return lotto.contains(bonusNumber.getValue());
    }

    private boolean isFiveMatched(int matchCount) { return matchCount == FIVE_COUNT; }

    private LottoRank getLottoRankByMatchCountAndBonusMatch(int matchCount, boolean isBonusMatched) {
        if (isFiveMatched(matchCount)) {
            return LottoRank.getByBonusMatchWhenMatchCountIsFive(isBonusMatched);
        }

        return LottoRank.getByMatchCountWhenBonusNotMatched(matchCount);
    }

    private LottoRank createLottoRank(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        boolean isBonusMatched = getIsBonusMatched(lotto);

        return getLottoRankByMatchCountAndBonusMatch(matchCount, isBonusMatched);
    }

    public List<LottoRank> createLottoRanks() {
        List<Lotto> elements = lottos.getElements();

        return elements.stream()
                .map(this::createLottoRank)
                .toList();
    }
}
