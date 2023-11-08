package lotto.controller;

import lotto.service.InputService;

public class Controller {
    private final InputService inputService = new InputService();
    public void run() {
        inputService.inputPurchaseAmount();
    }
}
