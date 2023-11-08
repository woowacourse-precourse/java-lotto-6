package lotto.domain;

import java.util.List;

public class Buyer {

    private int payment;

    private int ticketCnt;
    private List<Lotto> lotto;

    private int earningPrize;

    public Buyer(int payment, int ticketCnt) {
        this.payment = payment;
        this.ticketCnt = ticketCnt;
        this.lotto = Lotto.getLotto(ticketCnt);
        this.earningPrize = 0;
    }

    public int getPayment() {
        return payment;
    }

    public int getTicketCnt() {
        return ticketCnt;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public float getEarningPrize() {
        return earningPrize;
    }
    public void totalEarning (int earningPrize) {
        this.earningPrize = earningPrize;
    }
}
