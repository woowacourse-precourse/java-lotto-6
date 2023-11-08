package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private Money money;
    private LottoTickets lottoTickets;
    private Lotto correctLotto;
    private int bonus;

    public void run(){
        gameStart();
        gameResult();
    }

    private void gameStart(){
        createMoney();
        int ticket = getTicket(money);
        createLottoTickets(ticket);
        createCorrectLotto();
        createBonusNumber();
    }

    private void gameResult(){
        int[] lottoRank = lottoTickets.createLottoRank(correctLotto, bonus);
        double rateOfReturn = money.rateOfReturn(lottoRank);
        outputView.resultMessage(lottoRank, rateOfReturn);
    }

    private void createBonusNumber(){
        while (true){
            try {
                int temp = inputView.inputBonus();
                correctLotto.checkBonus(temp);
                bonus = temp;
                break;
            } catch (IllegalArgumentException e){
                outputView.println(e.getMessage());
            }
        }
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

    private void createLottoTickets(int ticket){
        lottoTickets = new LottoTickets(ticket);
        outputView.printLottoTickets(lottoTickets.getLottoTickets());
    }

    private void createMoney(){
        while(true){
            try {
                money = new Money(inputView.inputMoney());
                break;
            } catch (IllegalArgumentException e){
                outputView.println(e.getMessage());
            }
        }
    }

    private int getTicket(Money money){
        int ticket = money.divide1000();
        outputView.moneyInputResultMessage(ticket);
        return ticket;
    }
}
