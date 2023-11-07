package lotto.domain;

import lotto.domain.dto.Statistics;

final class StatisticsPublisher {

    private final LottoController controller;

    public StatisticsPublisher(LottoController controller) {
        this.controller = controller;
    }

    void publish(Lottos generatedLottos, Lotto winningNumber, BonusNumber bonusNumber, Money money) {
        Statistics statistics = new StatisticsCalculator().calculate(generatedLottos, winningNumber, bonusNumber, money);
        controller.showStatistics(statistics);
    }
}
