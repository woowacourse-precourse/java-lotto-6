package lotto.controller;

import static lotto.constant.message.ExceptionMessage.ERROR;

import lotto.constant.message.InputMessage;
import lotto.domain.LottoPurchase;
import lotto.service.PurchaseService;
import lotto.service.ResultService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseService purchaseService;
    private final ResultService resultService;
    private final WinningNumberService winningNumberService;
    private LottoPurchase lottoPurchase;

    public LottoController(InputView inputView, OutputView outputView, PurchaseService purchaseService,
                           ResultService resultService, WinningNumberService winningNumberService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseService = purchaseService;
        this.resultService = resultService;
        this.winningNumberService = winningNumberService;
    }

    public void play() {
        try {
            purchaseLotto();
            winningLottoNumber();
            winningLottoResult();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR.getMessage() + e.getMessage());
        }
    }

    private void purchaseLotto() {
        String purchaseMoney = inputView.getInputWithMessage(InputMessage.INPUT_PURCHASE.getMessage());
        lottoPurchase = purchaseService.getInputPurchase(purchaseMoney);
        outputView.printAboutPurchase(lottoPurchase.getAmount(), lottoPurchase.getPurchaseLotto());
    }

    private void winningLottoNumber() {
        String number = inputView.getInputWithMessage(InputMessage.INPUT_NUMBER.getMessage());
        winningNumberService.getInputWinningSixNumber(number);
        String bonusNum = inputView.getInputWithMessage(InputMessage.INPUT_BONUS.getMessage());
        winningNumberService.getInputWinningNumber(bonusNum);
    }

    private void winningLottoResult() {
        winningNumberService.getLottoWinningResult(lottoPurchase, resultService);
        outputView.outputWinningResult(resultService.getLottoResultCount(), resultService.getLottoProfitRate());
    }
}
