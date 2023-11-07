package lotto.controller;

import lotto.domain.LottoChanger;
import lotto.utility.Validation;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
    private int lottoCount;
    public LottoManager(){}

    public void startLottoService(){
        purchaseLotto(); //로또 구매하기


    }

    private void purchaseLotto(){
        String purchaseAmount;

        purchaseAmount = inputPurchaseAmount();
        LottoChanger lottoChanger = new LottoChanger(Integer.parseInt(purchaseAmount));
        lottoCount = lottoChanger.getLottoCount();
        OutputView.printLottoCount(lottoCount);
    }

    private String inputPurchaseAmount() {
        String purchaseAmount;

        try {
            purchaseAmount = InputView.readUserLottoPurchaseAmount();
            Validation.vaildatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException | IllegalStateException e) {
            ExceptionView.printExceptionMessage(e.getMessage());
            purchaseAmount = inputPurchaseAmount();
        }

        return purchaseAmount;
    }
}
