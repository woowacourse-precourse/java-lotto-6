package lotto.controller;

import lotto.utility.Validation;
import lotto.utility.enums.Standards;
import lotto.view.ExceptionView;
import lotto.view.InputView;

public class LottoManager {
    public LottoManager(){}

    public void startLottoService(){
        String purchaseAmount;
        int lottoCount;

        purchaseAmount = purchaseLotto();
        lottoCount = calculateLottoCount(purchaseAmount);
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

    private int calculateLottoCount(String purchaseAmount){
        return Integer.parseInt(purchaseAmount) / Standards.ONE_LOTTO_COST.getNumber();
    }
}
