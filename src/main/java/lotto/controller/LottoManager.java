package lotto.controller;

import lotto.domain.LottoChanger;
import lotto.utility.Validation;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
    public LottoManager(){}

    public void startLottoService(){
        purchaseLotto(); //로또 구매하기


    }

    private int purchaseLotto(){
        String purchaseAmount;

        purchaseAmount = inputPurchaseAmount();
        LottoChanger lottoChanger = new LottoChanger(Integer.parseInt(purchaseAmount));
        OutputView.printLottoCount(lottoChanger.getLottoCount());

        return lottoChanger.getLottoCount();
    }

    private String inputPurchaseAmount(){
        String purchaseAmount;

        try{
            purchaseAmount = InputView.readUserLottoPurchaseAmount();
            Validation.vaildatePurchaseAmount(purchaseAmount);
        }catch (IllegalArgumentException | IllegalStateException e){
            ExceptionView.printExceptionMessage(e.getMessage());
            purchaseAmount = inputPurchaseAmount();
        }

        return purchaseAmount;
    }
}
