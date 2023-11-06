package lotto.domain;

import java.util.List;

public class Customer {

    private List<Lotto> lottoTickets;
    private Payment payment;
    private int earnedMoney = 0;

    private WinningResult winningResult = null;

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

    public void setWinningResult(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    public WinningResult getWinningResult() {
        return winningResult;
    }

    public int getEarnedMoney() {
        return earnedMoney;
    }

    public void setEarnedMoney(int earnedMoney) {
        this.earnedMoney = earnedMoney;
    }

}
