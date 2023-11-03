package lotto.domain;

public class LottoVendingMachine {
    private int lottoTicketNumber;

    public LottoVendingMachine() {
    }

    public void purchaseLotto(int amount) {
        lottoTicketNumber = amount / 1000;
    }

    public int getLottoTicketNumber() {
        return lottoTicketNumber;
    }
}
