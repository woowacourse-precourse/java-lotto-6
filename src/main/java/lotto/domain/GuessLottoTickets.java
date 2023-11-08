package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuessLottoTickets {

    private final List<GuessLottoTicket> guessLottoTicketTickets;

    public GuessLottoTickets(int size) {
        this.guessLottoTicketTickets = this.generateLotteries(size);
    }

    public void printWinningLottoList() {
        for (GuessLottoTicket data : guessLottoTicketTickets) {
            Collections.sort(data.getLotto().getNumbers());
            System.out.println(data.getLotto().getNumbers());
        }
    }

    public List<Integer> countContainNumber(WinningLotto winningLotto) {
        List<Integer> countNumbers = new ArrayList<>();
        for (GuessLottoTicket guessLottoTicket : guessLottoTicketTickets) {
            Lotto guessNumbers = guessLottoTicket.getLotto();
            int numbers = guessNumbers.countContainNumbers(winningLotto.getLotto());

            countNumbers.add(numbers);
        }
        return countNumbers;
    }

    private List<GuessLottoTicket> generateLotteries(int size) {
        List<GuessLottoTicket> guessLottoTickets = new ArrayList<>();

        while (size > 0) {
            GuessLottoTicket guessLottoTicket = new GuessLottoTicket();
            guessLottoTickets.add(guessLottoTicket);
            size--;
        }

        return guessLottoTickets;

    }


}
