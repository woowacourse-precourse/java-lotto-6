package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.service.PrizeChecker;
import lotto.utils.LottoConstant;
import lotto.utils.LottoConstantValue;
import lotto.utils.Prize;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Prize, Integer> getPrizeCounts(PrizeChecker prizeChecker) {
        Map<Prize, Integer> prizeCounts = getInitializedPrizeCounts();
        for (Lotto lotto : lottos) {
            Prize prize = prizeChecker.calculatePrize(lotto);
            if (prize.equals(Prize.NO_PRIZE)) {
                continue;
            }
            Integer prizeCount = prizeCounts.getOrDefault(prize, LottoConstantValue.DEFAULT_COUNT.get());
            prizeCount++;
            prizeCounts.put(prize, prizeCount);
        }
        return prizeCounts;
    }

    private Map<Prize, Integer> getInitializedPrizeCounts() {
        Map<Prize, Integer> prizeCounts = new HashMap<>();
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NO_PRIZE) {
                continue;
            }
            prizeCounts.put(prize, LottoConstantValue.DEFAULT_COUNT.get());
        }
        return prizeCounts;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(LottoConstant.NEW_LINE.get()));
    }
}
