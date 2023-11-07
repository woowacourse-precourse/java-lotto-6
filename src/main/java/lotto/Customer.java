package lotto;

public class Customer {
    private LottoTerminal lottoTerminal = new LottoTerminal();

    public void expendForLotto(long spendingAmount) {
        lottoTerminal.receivePayment(spendingAmount);
    }
}
