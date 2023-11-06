package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private int ticket;

    public void run(){
        getTicket();
    }

    private void getTicket(){
        while(true){
            try {
                ticket = createTicket(createMoney());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private Money createMoney(){
        Money money = new Money(inputView.InputMoney());
        return money;
    }

    private int createTicket(Money money){
        int ticket = money.divideMoney1000();
        outputView.printMoneyInputResultMessage(ticket);
        return ticket;
    }
}
