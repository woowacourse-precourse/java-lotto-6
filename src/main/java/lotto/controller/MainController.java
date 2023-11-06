package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.view.OutputView;

public class MainController {
    private static final BuyerController buyerController = new BuyerController();
    private static final LottoController lottoController = new LottoController();

    public MainController() {
    }

    public static void run() {
        Buyer buyer = buyerController.createBuyer();
        Lottos lottoTicket = lottoController.createLottoTicket();
        OutputView.printMessage(lottoTicket);
    }
}
