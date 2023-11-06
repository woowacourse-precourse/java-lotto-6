package lotto.domain.controller;

import java.util.List;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.Order;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;
import lotto.domain.service.LottoCreateService;
import lotto.domain.service.LottoScoreUpdateService;
import lotto.domain.service.OrderCreateService;
import lotto.domain.service.StatisticsUpdateService;
import lotto.domain.view.inputer.Inputer;
import lotto.domain.view.printer.LottoPrinter;
import lotto.domain.view.printer.LottoStatisticsPrinter;

public class LottoController {
    private final LottoCreateService lottoCreateService;
    private final LottoScoreUpdateService lottoScoreUpdateService;
    private final OrderCreateService orderCreateService;
    private final StatisticsUpdateService statisticsUpdateService;

    public LottoController() {
        this.lottoCreateService = new LottoCreateService();
        this.lottoScoreUpdateService = new LottoScoreUpdateService();
        this.orderCreateService = new OrderCreateService();
        this.statisticsUpdateService = new StatisticsUpdateService();
    }

    public void run() {
        Order order = purchaseLotto();
        List<Lotto> purchaseLottos = createLottoByPurchasedAmount(order);
        WinningLotto winningLotto = createWinningLotto();
        findLottoResult(order, purchaseLottos, winningLotto);
        printResult(order);
    }

    private Order purchaseLotto() {
        Integer amount = Inputer.inputPurchaseAmount();
        Order order = orderCreateService.create(amount);
        return order;
    }

    private List<Lotto> createLottoByPurchasedAmount(Order order) {
        List<Lotto> purchaseLottos = lottoCreateService.purchaseLottos(order);
        LottoPrinter.printPurchased(purchaseLottos);
        return purchaseLottos;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = Inputer.inputWinningNumbers();
        Integer bonusNumber = Inputer.inputBonusNumber();
        WinningLotto winningLotto = lottoCreateService.createWinningLotto(winningNumbers, bonusNumber);
        return winningLotto;
    }

    private void findLottoResult(Order order, List<Lotto> purchaseLottos, WinningLotto winningLotto) {
        List<ScoreConfig> score = lottoScoreUpdateService.update(purchaseLottos, winningLotto);
        statisticsUpdateService.countWinningPoint(order, score);
    }

    private static void printResult(Order order) {
        LottoStatisticsPrinter.printStatistics(order);
        LottoStatisticsPrinter.printRateOfReturn(order);
    }
}
