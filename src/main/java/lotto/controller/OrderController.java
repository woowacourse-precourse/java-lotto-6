package lotto.controller;

import lotto.service.OrderService;
import lotto.values.ExceptionMessage;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.values.ExceptionMessage.NOT_NULL;

public class OrderController {
    OrderService orderLotto;
    Output output;

    public OrderController(){
        output = new Output();
        getMoney();
        output.printPurchasedResult(saleLotto());
    }
    public void getMoney(){
        Input input = new Input();

        String money;
        ExceptionMessage exceptionMessage = NOT_NULL;

        while(exceptionMessage != null){
            output.printMoneyPrompt();
            money = input.get();

            orderLotto = new OrderService();
            exceptionMessage = orderLotto.checkException(money);

            if (exceptionMessage != null) {
                output.printError(exceptionMessage);
            }
        }
    }
    public int saleLotto(){
        return orderLotto.executeOrder();
    }
}
