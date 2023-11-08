package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.constant.Rank;

public class LottoResults {

    private final Map<Rank, Integer> lottoResults;

    public LottoResults(Map<Rank, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults createLottoResults(Lottos lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> lottoResults = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> lottoResults.put(rank, 0));
        List<Rank> ranksOfLottos = lottos.getLottoCollection()
                .stream()
                .map(lotto -> lotto.getRank(winningNumbers))
                .toList();
        ranksOfLottos
                .forEach(rank -> lottoResults.put(rank, lottoResults.get(rank) + 1));
        return new LottoResults(lottoResults);
    }

    public double getRevenueRate(Money money) {
        Money revenue = Money.from(this);
        return (double) revenue.getMoney() / money.getMoney();
    }

    public int getRankCount(Rank rank) {
        return lottoResults.get(rank);
    }
}
