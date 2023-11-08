package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoGameService;
import lotto.service.LottoGameServiceImpl;
import lotto.view.InputHandler;
import lotto.view.PrintHandler;

public class LottoGameController {
    private static final LottoGameService lottoGameService = new LottoGameServiceImpl();

    public static void startLottoGame() {
        String purchaseAmountInput = InputHandler.getPurchaseInputMessage();
        PurchaseAmount purchaseAmount = lottoGameService.parsePurchaseAmount(purchaseAmountInput);

        LottoCount lottoCount = lottoGameService.computeLottoCount(purchaseAmount);
        Lottos lottos = lottoGameService.generateLottos(lottoCount);

        PrintHandler.printStartingPartOfLottoGame(lottoCount, lottos);

        playLottoGame(lottos, purchaseAmount);
    }

    private static void playLottoGame(Lottos lottos, PurchaseAmount purchaseAmount) {
        String winningNumbersInput = InputHandler.getWinningNumberInputMessage();
        WinningNumbers winningNumbers = lottoGameService.parseWinningNumbers(winningNumbersInput);

        String bonusNumberInput = InputHandler.getBonusNumberInputMessage(winningNumbers);
        BonusNumber bonusNumber = lottoGameService.parseBonusNumber(bonusNumberInput);

        Winnings winnings = lottoGameService.countMatchingNumbers(lottos, winningNumbers, bonusNumber);

        ReturnRate returnRate = lottoGameService.getReturnRate(purchaseAmount, winnings);

        PrintHandler.printEndingPartOfLottoGame(winnings);
    }
}
