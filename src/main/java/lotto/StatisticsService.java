package lotto;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.model.Lotto;
import lotto.model.WiningStatistics;
import lotto.model.WiningType;
import lotto.model.WiningTypeCount;

public class StatisticsService {

    public WiningStatistics calculateWiningStatistics(List<Integer> winingNumber, int bonus, List<Lotto> lottos) {
        WiningTypeCount winingTypeCount = calculateCountByWiningType(winingNumber, bonus, lottos);
        double rateOfReturn = winingTypeCount.calculateRateOfReturn(lottos);
        return new WiningStatistics(winingTypeCount, rateOfReturn);
    }

    private WiningTypeCount calculateCountByWiningType(List<Integer> winingNumber, int bonus,
                                                       List<Lotto> lottos) {
        Map<WiningType, Integer> winingCountMap = WiningType.winingCountToMap();
        lottos.forEach(lotto -> {
            int correctCount = lotto.compare(winingNumber);
            boolean hasBonus = lotto.containBonus(bonus);
            collectCountByWiningType(correctCount, hasBonus, winingCountMap);
        });
        return new WiningTypeCount(winingCountMap);
    }

    private void collectCountByWiningType(int correctCount, boolean hasBonus, Map<WiningType, Integer> winingCountMap) {
        Optional<WiningType> wining = WiningType.findByWiningType(correctCount, hasBonus);
        if (!wining.isEmpty()) {
            winingCountMap.computeIfPresent(wining.get(), (key, count) -> count + 1);
        }
    }
}
