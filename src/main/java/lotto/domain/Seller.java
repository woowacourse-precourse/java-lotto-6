package lotto.domain;

public class Seller {

    private final int deposit;

    public Seller(int deposit) {
        this.deposit = deposit;
    }

    public int getLottoTickets() {
        return deposit / 1000;
    }
}
