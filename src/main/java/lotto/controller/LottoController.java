package lotto.controller;

import java.util.List;
import lotto.domain.Answer;
import lotto.domain.Lotto;
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
        view.winningNumberInputGuideMsg();
        Lotto hitNumbers = createHitNumbers();
        view.bonusNumberInputGuideMsg();
        Answer answer = createAnswer(hitNumbers);

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

    private Answer createAnswer(Lotto hitNumbers) {
        Answer answer = null;
        try {
            int bonusNumber = receiveInputAndCreateBonusNumber();
            answer = new Answer(hitNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createAnswer(hitNumbers);
        }

        return answer;
    }

    private Lotto createHitNumbers() {
        Lotto hitNumbers = null;
        try {
            hitNumbers = receiveInputAndCreateHitNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createHitNumbers();
        }

        return hitNumbers;
    }

    private Lotto receiveInputAndCreateHitNumbers() {
        List<Integer> numbers = inputHandler.inputHitNumbers();
        return new Lotto(numbers);
    }

    private int receiveInputAndCreateBonusNumber() {
        return inputHandler.inputBonusNumber();
    }

    private TotalResult calcHitResult(Tickets tickets, Answer answer) {
        return tickets.compareTicketsToAnswer(answer);
    }
}
