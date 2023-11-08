package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public void printTickets() {
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static LottoTicket purchase(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 한 장은 1,000원입니다.");
        }

        int numberOfTickets = amount / 1000;
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(Lotto.generateRandomLotto());
        }

        return new LottoTicket(tickets);
    }

}
