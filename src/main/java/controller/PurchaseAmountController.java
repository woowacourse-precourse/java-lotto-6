package controller;

import domain.PurchaseAmount;
import service.PurchaseService;
import view.InputView;
import view.OutputView;

public class PurchaseAmountController {
    private final PurchaseService purchaseService;

    public PurchaseAmountController(){
        purchaseService = new PurchaseService();
    }

    public void generatePurchaseAmount(){
        String purchaseAmount = InputView.inputPurchaseAmount();
        try{
            PurchaseAmount amount = createPurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            generatePurchaseAmount();
        }
    }

    private PurchaseAmount createPurchaseAmount(final String purchaseAmount){
        return purchaseService.createPurchaseAmount(purchaseAmount);
    }
}
