package lotto.domain;

import lotto.domain.dto.Statistics;

import java.util.List;

final class StatisticsCalculator {

    Statistics calculate(Lottos generatedLottos, Lotto winningNumber, BonusNumber bonusNumber, Money money) {
        List<Result> results = generatedLottos.calculateResult(winningNumber, bonusNumber);
        Long reward = Result.sumOfRewards(results);
        double rate = (double) reward / money.money() * 100;
        return new Statistics(results, rate);
    }
}
