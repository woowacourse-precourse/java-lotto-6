package lotto.domain.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.Money;

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
