package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GuessLottoTickets {

    private final List<GuessLottoTicket> guessLottoTickets;

    public GuessLottoTickets(int size) {
        this.guessLottoTickets = this.generateLotteries(size);
    }

    public List<GuessLottoTicket> getGuessLottoTickets() {
        return guessLottoTickets;
    }

    public List<Integer> getGuessLottoTicketNumber(int size) {
        return guessLottoTickets.get(size).getLotto().getNumbers();
    }

    public void printWinningLottoList() {
        for (GuessLottoTicket data : guessLottoTickets) {
            List<Integer> numbers = data.getLotto().getNumbers();
            List<Integer> sortedNumbers = numbers.stream().sorted().toList();
            System.out.println(sortedNumbers);
        }
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
