package lotto;

public class LottoTicketMoney extends Money {
    private static final int singleTicketPrice = 1000;
    private final int totalTicketPrice;
    public LottoTicketMoney(int ticketPrice) {
        if (ticketPrice % singleTicketPrice != 0) {
            throw new IllegalArgumentException("티켓은 1장 당 1000원 입니다.");
        }
        this.totalTicketPrice = ticketPrice;
    }

    public int calculateTicketNumber() {
        return this.totalTicketPrice / singleTicketPrice;
    }
}
