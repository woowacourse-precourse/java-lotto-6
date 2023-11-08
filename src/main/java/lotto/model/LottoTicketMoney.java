package lotto.model;

public class LottoTicketMoney extends Money {
    private final int totalTicketPrice;
    private static final int singleTicketPrice = 1000;
    private static final String TICKET_PRICE_ERROR = "티켓은 1장 당 1000원 입니다.";
    public LottoTicketMoney(int ticketPrice) {
        if (ticketPrice % singleTicketPrice != 0) {
            throw new IllegalArgumentException(TICKET_PRICE_ERROR);
        }
        this.totalTicketPrice = ticketPrice;
    }

    public int calculateTicketNumber() {
        return this.totalTicketPrice / singleTicketPrice;
    }

    public double calculateIncomeRate(long literalPrice) {
        return literalPrice / (double) totalTicketPrice;
    }
}
