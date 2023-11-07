package lotto.controller;

import lotto.domain.LottoCount;
import lotto.service.LottoGameService;
import lotto.service.LottoGameServiceImpl;
import lotto.view.InputHandler;
import lotto.view.Printer;

public class LottoGameController {
    private static final LottoGameService lottoGameService = new LottoGameServiceImpl();

    public static void startLottoGame() {
        String purchaseAmount = InputHandler.getPurchaseInputMessage();
        final LottoCount lottoCount = lottoGameService.computeLottoCount(purchaseAmount);
        
        Printer.printLineBreak();
        Printer.printLottoCount(lottoCount);
    }
}
