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
import lotto.domain.util.generator.ILottoNumberGenerator;
import lotto.domain.util.referee.ILottoReferee;
import lotto.domain.view.inputer.InputHandler;
import lotto.domain.view.printer.LottoPrinter;
import lotto.domain.view.printer.LottoStatisticsPrinter;

public class LottoController {
    private final LottoCreateService lottoCreateService;
    private final LottoScoreUpdateService lottoScoreUpdateService;
    private final OrderCreateService orderCreateService;
    private final StatisticsUpdateService statisticsUpdateService;

    public LottoController(ILottoNumberGenerator iLottoNumberGenerator, ILottoReferee iLottoReferee) {
        this.lottoCreateService = new LottoCreateService(iLottoNumberGenerator);
        this.lottoScoreUpdateService = new LottoScoreUpdateService(iLottoReferee);
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
        Integer amount = InputHandler.inputPurchaseAmount();
        Order order = orderCreateService.create(amount);

        return order;
    }

    private List<Lotto> createLottoByPurchasedAmount(Order order) {
        List<Lotto> purchaseLottos = lottoCreateService.purchaseLottos(order);
        LottoPrinter.printPurchased(purchaseLottos);

        return purchaseLottos;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = InputHandler.inputWinningNumbers();
        Integer bonusNumber = InputHandler.inputBonusNumber();
        
        return lottoCreateService.createWinningLotto(winningNumbers, bonusNumber);
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
