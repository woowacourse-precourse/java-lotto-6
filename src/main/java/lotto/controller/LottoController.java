package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Tickets;

public class LottoController {
    private Tickets tickets;
    private Lotto lotto;
    private Bonus bonus;

    public void gernerateTicket(final int wallet) {
        this.tickets = new Tickets(wallet);
        this.tickets.generate();
    }

    public void inputLotto(final List<Integer> numbers, final int number) {
        this.lotto = new Lotto(numbers);
        this.bonus = new Bonus(number);
    }

    public void compareWinning() {
        List<List<Integer>> tickets = this.tickets.getTickets();
        List<Integer> lotto = this.lotto.getNumbers();
        int bonus = this.bonus.getNumber();
    }

    public void verifyWinRecord() {

    }

    public void verifyReturns() {

    }

}
