package lotto.controller;

import lotto.domain.Money;
import lotto.service.InputService;
import lotto.service.OutputService;

public class UserController {

    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();

    public int requestMoney() {
        outputService.requestMoney();
        Money money = inputService.requestMoney();
        return money.getMoney();
    }
}