package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    int ticket;
    private LottoTickets lottoTickets;
    private Lotto correctLotto;

    public void run(){
        getTicket();
        createLottoTickets(ticket);
        createCorrectLotto();
    }

    private void createCorrectLotto(){
        while(true){
            try {
                correctLotto = new Lotto(inputView.inputLotto());
                break;
            } catch (IllegalArgumentException e){
                outputView.println(e.getMessage());
            }
        }
    }

    private LottoTickets createLottoTickets(int ticket){
        lottoTickets = new LottoTickets(ticket);
        outputView.printLottoTickets(lottoTickets.getLottoTickets());
        return lottoTickets;
    }

    private void getTicket(){
        while(true){
            try {
                ticket = createTicket(createMoney());
                break;
            } catch (IllegalArgumentException e){
                outputView.println(e.getMessage());
            }
        }
    }

    private Money createMoney(){
        Money money = new Money(inputView.inputMoney());
        return money;
    }

    private int createTicket(Money money){
        int ticket = money.divideMoney1000();
        outputView.printMoneyInputResultMessage(ticket);
        return ticket;
    }
}
