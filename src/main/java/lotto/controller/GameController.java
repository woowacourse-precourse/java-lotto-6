package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.service.InputService;

public class GameController {

    InputService inputService = new InputService();
    public void init() {
        PurchaseAmount.from(inputService.readPurchaseAMount());
    }
}
