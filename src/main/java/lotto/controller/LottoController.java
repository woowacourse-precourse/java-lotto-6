package lotto.controller;

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

    public LottoController(InputView inputView, OutputView outputView, PurchaseService purchaseService, ResultService resultService,WinningNumberService winningNumberService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseService = purchaseService;
        this.resultService = resultService;
        this.winningNumberService = winningNumberService;
    }

    // model과 view에 의존해도 된다(코드 존재 가능)
    public void play(){
        try {
            String purchase = inputView.getInputWithMessage(InputMessage.INPUT_PURCHASE.getMessage());
            LottoPurchase purchases = purchaseService.getInputPurchase(purchase);
            outputView.printAboutPurchase(purchases.getAmount(),purchases.getPurchaseLotto());

            String number = inputView.getInputWithMessage(InputMessage.INPUT_NUMBER.getMessage());
            String bonusNum = inputView.getInputWithMessage(InputMessage.INPUT_BONUS.getMessage());
            winningNumberService.getInputWinningNumber(number, bonusNum);

            winningNumberService.getLottoWinningResult(purchases, resultService);
            outputView.outputWinningResult(resultService.getLottoResultCount(),resultService.getLottoProfitRate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
