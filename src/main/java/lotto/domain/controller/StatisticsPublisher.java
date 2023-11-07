package lotto.domain.controller;

import lotto.domain.component.StatisticsCalculator;
import lotto.domain.dto.Statistics;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.Money;

public final class StatisticsPublisher {

    private final LottoController controller;

    public StatisticsPublisher(LottoController controller) {
        this.controller = controller;
    }

    public Statistics publish(Lottos generatedLottos, Lotto winningNumber, BonusNumber bonusNumber, Money money) {
        Statistics statistics = new StatisticsCalculator().calculate(generatedLottos, winningNumber, bonusNumber, money);
        controller.showStatistics(statistics);

        return statistics;
    }
}
