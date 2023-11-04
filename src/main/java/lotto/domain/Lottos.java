package lotto.domain;

import static lotto.domain.NumberConstant.INITIAL_VALUE;
import static lotto.domain.NumberConstant.ONE_COUNT;
import static lotto.domain.RankPrize.values;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public RankResult determineRank(Lotto winningNumbers, LottoNumber bonusNumber) {
        EnumMap<RankPrize, Integer> ranks = initializeRanks();
        this.lottos.forEach(purchasedLotto -> {
            RankPrize result = purchasedLotto.determineRank(winningNumbers, bonusNumber);
            if (result != null) {
                ranks.compute(result, (rankPrize, winCounts) -> winCounts + ONE_COUNT.getValue());
            }
        });
        return new RankResult(ranks);
    }

    private static EnumMap<RankPrize, Integer> initializeRanks() {
        EnumMap<RankPrize, Integer> ranks = new EnumMap<>(RankPrize.class);
        Arrays.stream(values())
                .forEach(rankPrize -> ranks.put(rankPrize, INITIAL_VALUE.getValue()));
        return ranks;
    }
}
