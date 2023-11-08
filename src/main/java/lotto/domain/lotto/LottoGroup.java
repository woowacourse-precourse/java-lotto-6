package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.prize.Prize;
import lotto.domain.prize.ranking.rule.PrizeRanking;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getPrizeRankingCount(
            final Prize prize,
            final PrizeRanking prizeRanking
    ) {
        return (int) lottos.stream()
                .filter(lotto -> prizeRanking.getPrizeCriteria().getPrizeRule().test(lotto, prize))
                .count();
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
