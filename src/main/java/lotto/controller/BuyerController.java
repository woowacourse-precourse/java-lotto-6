package lotto.controller;

import lotto.domain.Buyer;
import lotto.service.BuyerService;

public class BuyerController {
    private final BuyerService buyerService = new BuyerService();
    public Buyer createBuyer() {
        return buyerService.generateBuyer();
    }
}
