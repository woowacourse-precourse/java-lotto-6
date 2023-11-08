package lotto.controller;

import java.util.List;
import lotto.domain.Answer;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Tickets;
import lotto.domain.TotalResult;
import lotto.util.InputHandler;
import lotto.view.View;

public class LottoController {
    private final View view = new View();
    private final InputHandler inputHandler = new InputHandler();

    public void run() {
        Money money = receiveInputAndGetMoney();
        Tickets tickets = money.createTicket();
        view.printLottoInfo(tickets);
        view.winningNumberInputGuideMsg();
        Lotto hitNumbers = createHitNumbers();
        view.bonusNumberInputGuideMsg();
        Answer answer = createAnswer(hitNumbers);

        TotalResult totalResult = calcHitResult(tickets, answer);
        view.hitResultTitle();
        view.printHitResult(totalResult);
        long sumOfPrize = totalResult.calcPrize();
        double rateOfReturn = money.calcRateOfReturn(sumOfPrize);
        view.printRateOfReturn(rateOfReturn);
    }

    private Money receiveInputAndGetMoney() {
        view.moneyInputGuideMsg();
        int money = inputHandler.inputMoney();
        return new Money(money);
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
