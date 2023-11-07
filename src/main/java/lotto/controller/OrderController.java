package lotto.controller;

import lotto.service.OrderService;
import lotto.view.Input;
import lotto.view.Output;

public class OrderController {
    Output output;
    int lottoNumber;
    int wastedMoney;

    private final static int DUMMY_VALUE = -1;

    public OrderController() {
        lottoNumber = DUMMY_VALUE;
        output = new Output();
        getMoney();
        output.printPurchasedResult(lottoNumber);
    }

    private void getMoney() {
        Input input = new Input();

        while (lottoNumber == DUMMY_VALUE) {
            output.printMoneyPrompt();
            String money = input.get();
            try {
                OrderService orderService = new OrderService();
                lottoNumber = orderService.generateLottoNumber(money);
                wastedMoney = Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public int getWastedMoney(){
        return wastedMoney;
    }
    public int getLottoNumber() {
        return lottoNumber;
    }
}
