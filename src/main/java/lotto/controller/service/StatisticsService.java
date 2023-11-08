package lotto.controller.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WiningNumbers;
import lotto.model.WiningStatistics;
import lotto.model.WiningTypeCount;

public class StatisticsService {

    public WiningStatistics calculateWiningStatistics(WiningNumbers winingNumbers, List<Lotto> lottos) {
        WiningTypeCount winingTypeCount = winingNumbers.countWining(lottos);
        double rateOfReturn = winingTypeCount.calculateRateOfReturn(lottos);
        return new WiningStatistics(winingTypeCount, rateOfReturn);
    }
}
