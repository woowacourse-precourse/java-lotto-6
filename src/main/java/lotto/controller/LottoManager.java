package lotto.controller;

import lotto.domain.LottoChanger;
import lotto.utility.Validation;
import lotto.utility.enums.Standards;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
    public LottoManager(){}

    public void startLottoService(){
        String purchaseAmount;

        purchaseAmount = purchaseLotto();
        LottoChanger lottoChanger = new LottoChanger(Integer.parseInt(purchaseAmount));
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
