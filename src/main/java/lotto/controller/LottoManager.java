package lotto.controller;

import lotto.utility.Validation;
import lotto.view.ExceptionView;
import lotto.view.InputView;

public class LottoManager {
    public LottoManager(){}

    public void startLottoService(){
        purchaseLotto();
    }

    private String purchaseLotto(){
        String purchaseAmount;

        try{
            purchaseAmount = InputView.readUserLottoPurchaseAmount();
            Validation.vaildatePurchaseAmount(purchaseAmount);
        }catch (IllegalArgumentException | IllegalStateException e){
            ExceptionView.printExceptionMessage(e.getMessage());
            purchaseAmount = purchaseLotto();
        }

        return purchaseAmount;
    }
}
