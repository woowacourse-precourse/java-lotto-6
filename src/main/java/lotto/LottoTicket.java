package lotto;

import java.util.List;

public class LottoTicket {

    private final List<List<Integer>> ticketNumbers;

    public LottoTicket(List<List<Integer>> ticketNumbers) {
        this.ticketNumbers = ticketNumbers;
    }

    private int calculate (int money) {
        int ticketCost = 1000;
        return money/ticketCost;
    }
}