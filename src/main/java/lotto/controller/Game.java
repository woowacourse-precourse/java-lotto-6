package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameSetting;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.utils.RandomNumberGenerator;
import lotto.view.Message;
import lotto.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    private final List<Winning> winnings;
    private final List<Lotto> tickets = new ArrayList<>();
    private Integer money;
    private List<Integer> numbers;
    private Integer bonusNumber;

    public Game(List<Winning> winnings) {
        this.winnings = winnings;
    }

    public void start() {
        money = View.requestMoney();
        buyTicket(money);
        numbers = View.requestNumbers();
        bonusNumber = View.requestNumberBonus(this.numbers);
        evaluateWinning();
        printWinningResult();
        calculatePNL();
        Console.close();
    }

    private void buyTicket(Integer money) {
        final int ticketEach = money / GameSetting.TICKET_PRICE.getValue();
        View.printMessageWithArgs(Message.RESPONSE_TICKETS, ticketEach);
        for (int i = 0; i < ticketEach; i++) {
            final List<Integer> numbers = RandomNumberGenerator.create();
            tickets.add(new Lotto(numbers));
            View.printMessageWithArgs(Message.RESPONSE_TICKET_NUMBERS, numbers.toString());
        }
        View.printNewLine();
    }

    private void evaluateWinning() {
        tickets.forEach(lotto -> lotto.evaluateWinning(numbers, bonusNumber, winnings));
    }

    private void printWinningResult() {
        View.printMessage(Message.RESPONSE_FINAL_TITLE);
        winnings.forEach(Winning::printResult);
    }

    private void calculatePNL() {
        final int profit = winnings.stream().mapToInt(Winning::calculatePrize).sum();
        final float pnl = (float) (Math.round((float) profit / money * 10) / 10.0);
        View.printMessageWithArgs(Message.RESPONSE_PNL,pnl);
    }
}
