package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGameService;
import lotto.service.LottoGameServiceImpl;
import lotto.view.InputHandler;
import lotto.view.PrintHandler;

public class LottoGameController {
    private static final LottoGameService lottoGameService = new LottoGameServiceImpl();

    public static void startLottoGame() {
        String purchaseAmount = InputHandler.getPurchaseInputMessage();

        LottoCount lottoCount = lottoGameService.computeLottoCount(purchaseAmount);
        Lottos lottos = lottoGameService.generateLottos(lottoCount);

        PrintHandler.printStartingPartOfLottoGame(lottoCount, lottos);

        playLottoGame(lottos);
    }

    private static void playLottoGame(Lottos lottos) {
        String winningNumbersInput = InputHandler.getWinningNumberInputMessage();
        WinningNumbers winningNumbers = lottoGameService.parseWinningNumbers(winningNumbersInput);

        String bonusNumberInput = InputHandler.getBonusNumberInputMessage(winningNumbers);
        BonusNumber bonusNumber = lottoGameService.parseBonusNumber(bonusNumberInput);
    }
}
