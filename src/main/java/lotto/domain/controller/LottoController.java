package lotto.domain.controller;

import java.util.List;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.Order;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;
import lotto.domain.service.LottoCreateService;
import lotto.domain.service.LottoScoreService;
import lotto.domain.service.OrderCreateService;
import lotto.domain.service.StatisticsModifyService;
import lotto.domain.view.inputer.Inputer;
import lotto.domain.view.printer.LottoPrinter;
import lotto.domain.view.printer.LottoStatisticsPrinter;

public class LottoController {
    private final LottoCreateService lottoCreateService;
    private final LottoScoreService lottoScoreService;
    private final OrderCreateService orderCreateService;
    private final StatisticsModifyService statisticsModifyService;

    public LottoController() {
        this.lottoCreateService = new LottoCreateService();
        this.lottoScoreService = new LottoScoreService();
        this.orderCreateService = new OrderCreateService();
        this.statisticsModifyService = new StatisticsModifyService();
    }

    public void run() {
        Integer amount = Inputer.inputPurchaseAmount();
        Order order = orderCreateService.create(amount);

        List<Lotto> purchaseLottos = lottoCreateService.purchaseLottos(order);
        LottoPrinter.printPurchased(purchaseLottos);

        List<Integer> winningNumbers = Inputer.inputWinningNumbers();
        Integer bonusNumber = Inputer.inputBonusNumber();
        WinningLotto winningLotto = lottoCreateService.createWinningLotto(winningNumbers, bonusNumber);

        List<ScoreConfig> score = lottoScoreService.getScore(purchaseLottos, winningLotto);
        statisticsModifyService.countWinningPoint(order, score);
        LottoStatisticsPrinter.printStatistics(order);
        LottoStatisticsPrinter.printRateOfReturn(order);
    }
}
