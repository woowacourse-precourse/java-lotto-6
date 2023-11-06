package lotto.controller;

import static lotto.view.constant.InputMessage.GET_PURCHASE_AMOUNT_MESSAGE;
import static lotto.view.constant.InputMessage.GET_WINNING_NUMBERS_MESSAGE;

import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import lotto.service.LottoPurchaseService;
import lotto.service.LottosService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottosService lottosService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoPurchaseService = new LottoPurchaseService();
        this.lottosService = new LottosService();
    }

    public void play() {
        String purchaseAmount = getPurchaseAmount();
        LottoPurchase lottoPurchase = lottoPurchaseService.createLottoPurchase(purchaseAmount);
        Lottos lottos = lottosService.createLottos(lottoPurchase);
        printLottoNumbers(lottos);

        String winningNumbers = getWinningNumbers();
    }

    public String getPurchaseAmount() {
        OutputView.printMessage(GET_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return inputView.readAmountInput();
    }

    public String getWinningNumbers() {
        OutputView.printMessage(GET_WINNING_NUMBERS_MESSAGE.getMessage());
        return inputView.readWinningNumbers();
    }

    public void printLottoNumbers(Lottos lottos) {
        outputView.printLottoNumbers(lottos);
    }
}
