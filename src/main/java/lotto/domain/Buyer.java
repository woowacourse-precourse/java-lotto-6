package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private int payment;

    private int ticketCnt;
    private List<Lotto> lotto;

    public Buyer(int payment, int ticketCnt) {
        this.payment = payment;
        this.ticketCnt = ticketCnt;
        this.lotto = Lotto.getLotto(ticketCnt);
    }

    public int getTicketCnt() {
        return ticketCnt;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
