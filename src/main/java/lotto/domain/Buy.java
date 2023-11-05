package lotto.domain;

public class Buy {
    private final int buyPrice;
    private final int buyTicketCount;

    public Buy(int buyPrice) {
        this.buyPrice = buyPrice;
        this.buyTicketCount = buyPrice / 1000;
    }

    public int getBuy() {
        return buyTicketCount;
    }
}
