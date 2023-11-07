package lotto.controller;

import lotto.service.OrderService;
import lotto.view.Input;
import lotto.view.Output;

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
        boolean checkException = false;

        while(!checkException){
            output.printMoneyPrompt();
            orderLotto = new OrderService();
            try{
                money = input.get();
                checkException = orderLotto.checkException(money);
            }catch (IllegalArgumentException e){
                output.printError(e.getMessage());
            }
        }
    }
    public int saleLotto(){
        return orderLotto.executeOrder();
    }
}
