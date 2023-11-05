package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Tickets;

public class LottoController {

    public void gernerateTicket(final int wallet) {
        Tickets tickets = new Tickets(wallet);
        tickets.generate();
    }

    public void inputLotto(final List<Integer> numbers, final int bonus) {
        validateInput(numbers, bonus);
    }

    private void validateInput(List<Integer> numbers, int bonus) {
        new Lotto(numbers);
        new Bonus(bonus);
    }

    public void compareWinning() {

    }

    public void verifyWinRecord() {

    }

    public void verifyReturns() {

    }

}
