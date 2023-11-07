package lotto.controller;

import lotto.service.OrderLottoService;
import lotto.values.ExceptionMessage;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.values.ExceptionMessage.NOT_NULL;

public class OrderController {
    OrderLottoService orderLotto;
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

            orderLotto = new OrderLottoService();
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
