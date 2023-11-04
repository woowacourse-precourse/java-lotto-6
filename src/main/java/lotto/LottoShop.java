package lotto;

public class LottoShop {

    private Customer customer;
    private WinLotto winLotto;

    public LottoShop(Customer customer, WinLotto winLotto) {

        this.customer = customer;
        this.winLotto = winLotto;
    }

    public void compareWinLotto() {

        customer.checkWinLotto(winLotto);
        Output.printResult();
        Output.printRateOfReturn(customer);
    }
}
