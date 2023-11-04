package lotto.controller;

import lotto.service.PurchaseService;

public class LottoController {
    private final PurchaseService purchaseService = new PurchaseService();
    // model과 view에 의존해도 된다(코드 존재 가능)
    public void play(){
        try {
            purchaseService.getInputPurchase();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
