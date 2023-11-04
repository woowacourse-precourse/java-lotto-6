package lotto.controller;

import lotto.service.PurchaseService;
import lotto.service.WinningNumberService;

public class LottoController {
    private final PurchaseService purchaseService = new PurchaseService();
    private final WinningNumberService winningNumberService = new WinningNumberService();
    // model과 view에 의존해도 된다(코드 존재 가능)
    public void play(){
        try {
            purchaseService.getInputPurchase();
            winningNumberService.getInputWinningNumber();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
