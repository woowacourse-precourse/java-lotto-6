package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoBundle {

    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> calculateTotalRank(Lotto winningLotto, BonusNumber bonusNumber) {
        Map<Rank, Integer> map = new EnumMap<>(Rank.class);
        int defaultCountOfRank = 0;

        for (Lotto lotto : lottos) {
            Rank rank = Rank.from(
                    lotto.calculateMatchCount(winningLotto),
                    lotto.contains(bonusNumber.getNumber())
            );

            map.put(
                    rank,
                    map.getOrDefault(rank, defaultCountOfRank) + 1
            );
        }
        return map;
    }

    public float calculateEarningRate(int totalPrize) {
        return (float) totalPrize / lottos.size() / LottoGenerator.priceOfLotto * 100;
    }
}
