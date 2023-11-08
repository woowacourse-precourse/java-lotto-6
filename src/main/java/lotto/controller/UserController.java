package lotto.controller;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
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

    public List<Integer> requestWinningNumber() {
        outputService.requestWinningNumber();
        WinningNumber winningNumber = inputService.requestWinningNumber();
        return winningNumber.getWinningNumber();
    }
}