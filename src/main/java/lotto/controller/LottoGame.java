package lotto.controller;

import lotto.domain.PurchaseManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private static InputView inputView;
    private static OutputView outputView;
    private static PurchaseManager purchaseManager;

    public LottoGame(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startGame(){
        purchase();
    }
    private void purchase(){
        boolean validateInput=false;
        while(!validateInput){
            validateInput = validatePurchaseAmount(inputView.inputPurchaseAmount());
        }
        outputView.printResult(purchaseManager.getPurchaseNumber());
    }
    private boolean validatePurchaseAmount(String purchaseAmount){
        try {
            purchaseManager = new PurchaseManager(purchaseAmount);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
