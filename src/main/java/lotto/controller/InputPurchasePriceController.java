package lotto.controller;

import lotto.model.PurchasePrice;
import lotto.service.InputPurchasePriceService;

public class InputPurchasePriceController {
    private final InputPurchasePriceService inputPurchasePriceService;

    public InputPurchasePriceController(InputPurchasePriceService inputPurchasePriceService) {
        this.inputPurchasePriceService = inputPurchasePriceService;
    }

    public PurchasePrice purchasePrice() {
        // 구입 금액 입력
        return inputPurchasePriceService.inputPurchasePrice();
    }
}
