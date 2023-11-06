package lotto.model;

import java.util.List;

public class LottoTickets {
    private List<Lotto> tickets;

    public LottoTickets(int amount) {

    }

    public LottoTickets(List<Lotto> lotto){
        this.tickets = lotto;
    }

    public LottoTickets makeTickets() {
        return null;
    }
}
