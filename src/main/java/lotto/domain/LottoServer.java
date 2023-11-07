package lotto.domain;

import lotto.domain.dto.Purchase;
import lotto.domain.dto.Statistics;
import lotto.io.InputPort;
import lotto.io.OutputPort;

public final class LottoServer {

    private final LottoController controller;
    private final LottoPublisher lottoPublisher;
    private final StatisticsPublisher statisticsPublisher;

    public LottoServer(LottoController controller, LottoGenerator generator) {
        this.controller = controller;
        this.lottoPublisher = new LottoPublisher(generator, controller);
        this.statisticsPublisher = new StatisticsPublisher(controller);
    }

    public void run() {
        Money money = controller.receiveMoney();
        Lottos generatedLottos = lottoPublisher.publish(money);

        Lotto winningNumber = controller.receiveWinningNumber();
        BonusNumber bonusNumber = controller.receiveBonusNumber(winningNumber);

        statisticsPublisher.publish(generatedLottos, winningNumber, bonusNumber, money);
    }
}
