package lotto.controller;

import lotto.domain.Lotto;
import lotto.utils.RandomNumberGenerator;
import lotto.view.Message;
import lotto.view.View;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int bonusNumber;
    private List<Integer> numbers;
    private final List<Lotto> tickets = new ArrayList<>();

    public void start() {

        buyTicket(View.requestMoney());
        this.numbers = View.requestNumbers();
        this.bonusNumber = View.requestNumberBonus(this.numbers);
    }

    private void buyTicket(Integer ticketEach) {
        View.printMessageWithArgs(Message.RESPONSE_TICKETS, ticketEach);
        for (int i = 0; i < ticketEach; i++) {
            final  List<Integer> numbers = RandomNumberGenerator.create();
            tickets.add(new Lotto(numbers));
            View.printMessageWithArgs(Message.RESPONSE_TICKET_NUMBERS,numbers.toString());
        }
        View.printNewLine();
    }
}
