package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.NumberChecker;
import lotto.view.OutputView;

public class MainController {
    private static final BuyerController buyerController = new BuyerController();
    private static final LottoController lottoController = new LottoController();

    public MainController() {
    }

    public static void run() {
        Buyer buyer = buyerController.createBuyer();
        Lottos lottoTicket = lottoController.createLottoTicket(buyer);

        OutputView.printMessage(lottoTicket, buyer);

        NumberChecker numberChecker = lottoController.createNumberChecker();

        LottoStatistics lottoResult = numberChecker.getLottoResult(lottoTicket, buyer);

        OutputView.printMessage(lottoResult.generateLottoStatisticsForm());

    }
}
