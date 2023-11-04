package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public List<LottoTicket> purchaseTickets(int money) {
        int numberOfTickets = money / LOTTO_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(generateRandomTicket());
        }

        return tickets;
    }

    private LottoTicket generateRandomTicket() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return new LottoTicket(numbers.subList(0, 6));
    }
}
