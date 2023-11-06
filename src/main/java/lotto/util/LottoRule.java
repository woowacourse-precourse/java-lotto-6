package lotto.util;

public enum LottoRule {

    STANDARD(1,45,6, 1000);

    private final int startNumber;
    private final int lastNumber;
    private final int lottoSize;
    private final int ticketPrice;

    LottoRule(int startNumber, int lastNumber, int lottoSize, int ticketPrice) {
        this.startNumber = startNumber;
        this.lastNumber = lastNumber;
        this.lottoSize = lottoSize;
        this.ticketPrice = ticketPrice;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public int getLottoSize() {
        return lottoSize;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
}
