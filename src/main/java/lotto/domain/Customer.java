package lotto.domain;

import java.util.List;

public class Customer {

    private List<Lotto> lottoTickets;
    private Payment payment;
    private int winningPrize = 0;

    private LottoResult lottoResult = null;

    public Customer(Payment payment, List<Lotto> lottoTickets) {
        this.payment = payment;
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getPayment() {
        return payment.getPayment();
    }

    public void setLottoResult(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public void setWinningPrize(int winningPrize) {
        this.winningPrize = winningPrize;
    }

}
