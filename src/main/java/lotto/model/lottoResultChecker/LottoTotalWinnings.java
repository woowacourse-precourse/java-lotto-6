package lotto.model.lottoResultChecker;

public class LottoTotalWinnings {
    private final int ticketCost;

    public LottoTotalWinnings(int ticketCost) {
        this.ticketCost = ticketCost;
    }

    public long calculateTotalSales(int numberOfTicketsSold) {
        return (long) ticketCost * numberOfTicketsSold;
    }
}