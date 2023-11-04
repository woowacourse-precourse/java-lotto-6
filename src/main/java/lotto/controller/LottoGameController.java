package lotto.controller;

import static lotto.utils.InputException.NOT_DIGIT_FORM;

import lotto.service.LottoGameService;
import lotto.utils.InputException;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameController {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(
            ConsoleInputView inputView,
            ConsoleOutputView outputView,
            LottoGameService lottoGameService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        int purchaseAmount = lottoGameService.readPurchaseAmountFromBuyer();
    }
}
