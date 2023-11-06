package lotto;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.model.Lotto;
import lotto.model.WiningStatistics;
import lotto.model.WiningType;

public class StatisticsService {

    public WiningStatistics calculateWiningStatistics(List<Integer> winingNumber, int bonus, List<Lotto> lottos) {
        Map<WiningType, Integer> winingCountMap = calculateCountByWiningType(winingNumber, bonus, lottos);
        long amount = WiningType.sumAmount(winingCountMap);
        double rateOfReturn = Math.round((amount / (lottos.size() * 1000.0)) * 1000.0) / 1000.0 * 100.0;
        return new WiningStatistics(rateOfReturn, winingCountMap);
    }

    private Map<WiningType, Integer> calculateCountByWiningType(List<Integer> winingNumber, int bonus,
                                                                List<Lotto> lottos) {
        Map<WiningType, Integer> winingCountMap = WiningType.winingCountToMap();
        lottos.forEach(lotto -> {
            int correctCount = lotto.compare(winingNumber);
            boolean hasBonus = lotto.containBonus(bonus);
            Optional<WiningType> wining = WiningType.findByWiningType(correctCount, hasBonus);
            if (!wining.isEmpty()) {
                winingCountMap.computeIfPresent(wining.get(), (key, count) -> count + 1);
            }
        });
        return winingCountMap;
    }
}
