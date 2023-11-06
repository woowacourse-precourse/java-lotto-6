package lotto.repository;

import lotto.domain.Ticket;
import lotto.domain.ticket.Bonus;
import lotto.domain.ticket.Lotto;

import java.util.List;

public class LottoRepository {

    private Ticket winningNumbers;  // 당첨 로또
    private List<Ticket> myTickets; // 사용자의 로또
    

    // 사용자의 로또를 저장한다
    public void buyTicket(List<Integer> numbers, int number) {
        myTickets.add(new Ticket(new Lotto(numbers),new Bonus(number)));
    }

    // 당첨 로또를 저장한다
    public void drawLotto(List<Integer> numbers, int number) {
        winningNumbers = new Ticket(new Lotto(numbers), new Bonus(number));
    }


}
