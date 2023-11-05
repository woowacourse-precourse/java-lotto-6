package lotto.controller;

import lotto.domain.PurchaseManager;
import lotto.view.InputView;

public class LottoGame {
    private static InputView inputView;
    private static PurchaseManager purchaseManager;

    public LottoGame(){
        inputView = new InputView();
        //todo outputView
    }

    public void startGame(){
        purchase();
    }
    private void purchase(){
        boolean validateInput=false;
        while(!validateInput){
            validateInput = validatePurchaseAmount(inputView.inputPurchaseAmount());
        }
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
