package lotto.controller;

import lotto.service.OrderService;
import lotto.view.Input;
import lotto.view.Output;

public class OrderController {
    Output output;
    private final static int DUMMY_VALUE = -1;
    OrderService service;

    public OrderController(OrderService orderService) {
        this.service = orderService;
        output = new Output();
        output.printPurchasedResult(getMoney());
    }

    public int getMoney() {
        Input input = new Input();
        int lottoNumber = DUMMY_VALUE;
        while (lottoNumber == DUMMY_VALUE) {
            output.printMoneyPrompt();
            String money = input.get();
            try {
                lottoNumber = service.generateLottoNumber(money);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
        return lottoNumber;
    }
}
