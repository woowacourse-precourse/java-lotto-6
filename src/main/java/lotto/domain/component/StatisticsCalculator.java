package lotto.domain.component;

import lotto.domain.dto.Statistics;
import lotto.domain.model.*;

import java.util.List;

public final class StatisticsCalculator {

    public Statistics calculate(Lottos generatedLottos, Lotto winningNumber, BonusNumber bonusNumber, Money money) {
        List<Result> results = generatedLottos.calculateResult(winningNumber, bonusNumber);
        Long reward = Result.sumOfRewards(results);
        double rate = (double) reward / money.money() * 100;
        return new Statistics(results, rate);
    }
}
