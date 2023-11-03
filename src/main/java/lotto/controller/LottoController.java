package lotto.controller;

public class LottoController {

    private final PurchaseController purchaseController = new PurchaseController();

    public void start() {
        int purchaseAmount = purchaseController.getPurchaseAmount();
        System.out.println(purchaseAmount);
    }
}