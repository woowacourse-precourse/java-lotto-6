package controller;

import domain.PurchaseAmount;
import service.PurchaseService;
import view.InputView;
import view.OutputView;

public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(){
        purchaseService = new PurchaseService();
    }

    public PurchaseAmount generatePurchaseAmount(){
        int purchaseAmount = InputView.inputPurchaseAmount();
        try{
            return createPurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            return generatePurchaseAmount();
        }
    }

    private PurchaseAmount createPurchaseAmount(final int purchaseAmount){
        return purchaseService.createPurchaseAmount(purchaseAmount);
    }
}
