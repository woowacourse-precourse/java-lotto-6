package lotto.controller;

import java.util.List;
import lotto.domain.Answer;
import lotto.domain.HitNumbers;
import lotto.domain.Tickets;
import lotto.domain.TotalResult;
import lotto.util.InputHandler;
import lotto.util.LottoMachine;
import lotto.view.View;

public class LottoController {
    private final View view = new View();
    private final InputHandler inputHandler = new InputHandler();

    public void run() {
        int money = receiveInputAndGetMoney();
        Tickets tickets = createTickets(money);
        view.printLottoInfo(tickets);
        Answer answer = createAnswer();

        TotalResult totalResult = calcHitResult(tickets, answer);
        view.hitResultTitle();
        view.printHitResult(totalResult);
        double rateOfReturn = totalResult.calcRateOfReturn(money);
        view.printRateOfReturn(rateOfReturn);
    }

    private int receiveInputAndGetMoney() {
        view.moneyInputGuideMsg();
        return inputHandler.inputMoney();
    }

    private Tickets createTickets(int money) {
        LottoMachine machine = new LottoMachine();
        return machine.generateTickets(money);
    }

    private Answer createAnswer() {
        view.winningNumberInputGuideMsg();
        HitNumbers hitNumbers = receiveInputAndCreateHitNumbers();
        view.bonusNumberInputGuideMsg();
        int bonusNumber = receiveInputAndCreateBonusNumber(hitNumbers);
        return new Answer(hitNumbers, bonusNumber);
    }

    private HitNumbers receiveInputAndCreateHitNumbers() {
        List<Integer> rawHitNumbers = inputHandler.inputHitNumbers();
        return new HitNumbers(rawHitNumbers);
    }

    private int receiveInputAndCreateBonusNumber(HitNumbers hitNumbers) {
        return inputHandler.inputBonusNumber(hitNumbers);
    }

    private TotalResult calcHitResult(Tickets tickets, Answer answer) {
        return tickets.compareTicketsToAnswer(answer);
    }
}
