package lotto;

public class Customer {
    private LottoTerminal lottoTerminal;

    public Customer(LottoTerminal lottoTerminal) {
        this.lottoTerminal = lottoTerminal;
    }

    public void expendForLotto(long spendingAmount) {
        lottoTerminal.receivePayment(spendingAmount);
    }
}
