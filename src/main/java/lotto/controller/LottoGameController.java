package lotto.controller;

import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.service.LottoGameService;
import lotto.service.LottoGameServiceImpl;
import lotto.view.InputHandler;
import lotto.view.PrintHandler;
import lotto.view.Printer;

public class LottoGameController {
    private static final LottoGameService lottoGameService = new LottoGameServiceImpl();

    public static void startLottoGame() {
        String purchaseAmount = InputHandler.getPurchaseInputMessage();
        LottoCount lottoCount = lottoGameService.computeLottoCount(purchaseAmount);

        Printer.printLineBreak();

        Printer.printLottoCount(lottoCount);
        Lottos lottos = lottoGameService.generateLottos(lottoCount);
        PrintHandler.printLottos(lottos);

        Printer.printLineBreak();
    }
}
