package lotto.controller;

import lotto.service.OrderService;
import lotto.view.Input;
import lotto.view.Output;

public class OrderController {
    Output output;
    private final static int DUMMY_VALUE = -1;

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        output = new Output();
        output.printPurchasedResult(getMoney());
    }

    private int getMoney() {
        Input input = new Input();
        int lottoNumber = DUMMY_VALUE;
        while (lottoNumber == DUMMY_VALUE) {
            output.printMoneyPrompt();
            String money = input.get();
            try {
                lottoNumber = orderService.generateLottoNumber(money);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
        return lottoNumber;
    }
}
