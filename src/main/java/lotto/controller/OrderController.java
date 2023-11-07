package lotto.controller;

import lotto.service.OrderService;
import lotto.view.Input;
import lotto.view.Output;


public class OrderController {
    Output output;
    int lottoNumber;

    public OrderController(){
        output = new Output();
        getMoney();
        output.printPurchasedResult(lottoNumber);
    }
    private void getMoney(){
        Input input = new Input();
        OrderService orderLotto = null;

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

        this.lottoNumber = orderLotto.getLottoNumber();
    }
    public int getLottoNumber(){
        return lottoNumber;
    }
}
